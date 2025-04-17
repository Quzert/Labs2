section .data
    msg: db "No", 10
    msgLen: equ $-msg
    space: db " ", 10
    spaceLen: equ $-space
    step: db "ULDDRRUU", 10
    stepLen: equ $-step
    startPos: db 100

section .bss
    string_buffer resb 10
    buffer resb 10
    uy resb 6
    doy resb 6
    lx resb 6
    rx resb 6
    x resb 6
    y resb 6

section .text
    global _start

_start:
    mov ecx, 0
    mov esi, step
    mov eax, [startPos]
    mov [x], eax
    mov [y], eax
    mov [uy], eax
    mov [doy], eax
    mov [lx], eax
    mov [rx], eax
    dec esi


.next_step:
    inc esi ; Переходим к следующему символу
    movzx eax, byte [esi]

    cmp al, 0  ; Сравниваем младший байт eax (al) с нулем
    je .sized

    inc ecx

    cmp al, 'U'
    je .up

    cmp al, 'D'
    je .down

    cmp al, 'L'
    je .left

    cmp al, 'R'
    je .right

    jmp .sized

.up:
    mov eax, [y]
    dec eax
    mov [y], eax ; Уменьшаем y
    cmp eax, [uy]  ; 99 100

    jg .next_step ; Если y больше uy, продолжаем

    mov [uy], eax ; Иначе, uy = y
    jmp .next_step ; Переходим к следующему шагу

.down:
    mov eax, [y]
    inc eax
    mov [y], eax ; Увеличиваем y
    cmp eax, [doy]

    jl .next_step ; Если y меньше doy, продолжаем

    mov [doy], eax ; Иначе, doy = y
    jmp .next_step ; Переходим к следующему шагу

.left:
    mov eax, [x]
    dec eax
    mov [x], eax ; Уменьшаем x
    cmp eax, [lx]

    jg .next_step ; Если x больше lx, продолжаем

    mov [lx], eax ; Иначе, lx = x
    jmp .next_step ; Переходим к следующему шагу

.right:
    mov eax, [x]
    inc eax
    mov [x], eax ; Увеличиваем x
    cmp eax, [rx]

    jl .next_step ; Если x меньше rx, продолжаем

    mov [rx], eax ; Иначе, rx = x
    jmp .next_step ; Переходим к следующему шагу

.sized:
    mov eax, [lx]
    add eax, 3;102
    cmp eax, [rx] ; 102 101
    jl .messeg
    je .messeg
    mov eax, [uy]
    add eax, 3 ; 102
    cmp eax, [doy] ; 102 101
    jl .messeg
    je .messeg
    jmp .printX

.printY:
    mov rax, 1
    mov rdi, 1
    mov rsi, space
    mov rdx, spaceLen
    syscall

    mov eax, [uy]
    mov ebx, 100
    sub ebx, eax
    add ebx, 1
    mov [uy], ebx
    mov ax, [uy]
    mov r8, 0
    jmp .print_number

.printX:
    mov eax, [lx]
    mov ebx, 100
    sub ebx, eax
    add ebx, 1
    mov [lx], ebx
    mov ax, [lx]
    mov r8, 37
    jmp .print_number


.print:
    mov ax, [uy] ; Сохраняем большее число в eax


.print_number:

    mov rcx, 0          ; Счетчик цифр
    mov bx, 10          ; Основание системы счисления
    mov rdi, string_buffer + 9 ; Указатель на конец буфера (64-битный регистр)
    mov byte [rdi], 0

.convert_loop:
    xor rdx, rdx        ; Очищаем старшую часть
    div bx            ; dx:ax = ax / bx, остаток в dx
    add dl, '0'       ; Преобразуем остаток в ASCII-цифру (dl - младший байт rdx)
    dec rdi           ; Перемещаем указатель влево
    mov [rdi], dl     ; Сохраняем цифру в буфере
    inc rcx           ; Увеличиваем счетчик цифр
    cmp ax, 0         ; Проверяем, не стало ли число нулем
    jnz .convert_loop

    ; Вывод строки из буфера
    mov rax, 1        ; sys_write
    mov rdi, 1        ; stdout
    mov rsi, string_buffer + 9 ; Указатель на конец буфера (на нуль-терминатор)
    sub rsi, rcx      ; Сдвигаем указатель на начало сформированной строки
    mov rdx, rcx      ; Длина строки
    syscall

    cmp r8, 37
    je .printY
    jmp .exit

.messeg:
    mov rax, 1
    mov rdi, 1
    mov rsi, msg
    mov rdx, msgLen
    syscall

.exit:
    ; Выход
    mov rax, 60       ; sys_exit
    xor rdi, rdi
    syscall
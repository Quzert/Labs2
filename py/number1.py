m = 3
n = 3
s = "ULDDRRUU"

def startPosFinder(m,n,s):
    x = 0
    y = 0
    rX = 0
    lX = 0
    uY = 0
    dY = 0
    for i in s:
        if i == "D":
            y += 1
            if y > dY:
                dY = y
        elif i == "U":
            y -= 1
            if y < uY:
                uY = y
        elif i == "L":
            x -= 1
            if x < lX:
                lX = x
        elif i == "R":
            x += 1
            if x > rX:
                rX = x

    if rX-lX >= m or dY-uY >= n:
        return "No"
    return 1 - lX , 1 - uY



print(startPosFinder(m,n,s))



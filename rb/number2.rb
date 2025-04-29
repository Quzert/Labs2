require 'set'

def is_valid_username_rb(username)
    return false unless username.length.between?(6, 30)
    return false if username.match?(/[&=+<>,_'-]/)
    return false if username.start_with?('.') || username.end_with?('.')
    return false if username.include?('..')
    return false unless username.match?(/\A[a-zA-Z0-9.*]*\z/)
    true
end

def email_count_rb(email_list)
    # Используем Set для хранения уникальных нормализованных адресов
    unique_emails = Set.new

    email_list.each do |email|
        at_pos = email.index('@')
        unless at_pos && at_pos > 0 && at_pos < email.length - 1
            next
        end

        local = email[0...at_pos]
        domain = email[at_pos+1..-1]

        # Сначала валидируем оригинальное имя пользователя
        unless is_valid_username_rb(local)
            next
        end

        # Нормализация: убираем все после '*' и удаляем все '.'
        star_pos = local.index('*')
        local = local[0...star_pos] if star_pos
        cleaned_local = local.gsub('.', '')

        unique_emails.add(cleaned_local + "@" + domain)
    end
    unique_emails.size
end

# Example Usage:
address_list1 = ["mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru"]
address_list2 = ["mar.pha*science@corp.nstu.ru", "marpha*scie.nce@corp.nstu.ru", "marph.a*s.c.i.e.n.c.e@corp.nstu.ru"]
address_list3 = ["mar.pha*science@co.rp.nstu.ru", "marpha*scie.nce@corp.nstu.ru", "marph.a*s.c.i.e.n.c.e@corp.nstu.ru"]

puts "List 1 Count: #{email_count_rb(address_list1)}"
puts "List 2 Count: #{email_count_rb(address_list2)}"
puts "List 3 Count: #{email_count_rb(address_list3)}"
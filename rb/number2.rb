def is_valid_username(username)
  return false if username.length < 6 || username.length > 30
  return false if username.start_with?('.') || username.end_with?('.')
  return false if username.include?('..')
  return false if username =~ /[&=+<>,_'\-]/
  return false unless username =~ /^[a-zA-Z0-9.]*$/
  true
end

def email_count(email_list)
  unique_emails = Set.new

  email_list.each do |email|
    local, domain = email.split('@')
    unless is_valid_username(local)
      puts "Некорректное имя пользователя: #{local}"
      next
    end

    local = local.gsub('.', '').split('*').first
    unique_emails.add("#{local}@#{domain}")
  end

  unique_emails.size
end

address_list1 = ["mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru"]
puts email_count(address_list1)
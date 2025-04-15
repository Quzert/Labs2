require 'set'

addres_list1 = ["mar.pha@corp.nstu.ru", "marpha@corp.nstu.ru", "marph.a@corp.nstu.ru"] # 1
addres_list2 = ["mar.pha+science@corp.nstu.ru", "marpha+scie.nce@corp.nstu.ru", "marph.a+s.c.i.e.n.c.e+@corp.nstu.ru"] # 1
addres_list3 = ["mar.pha+science@co.rp.nstu.ru", "marpha+scie.nce@corp.nstu.ru", "marph.a+s.c.i.e.n.c.e+@corp.nstu.ru"] # 2

def email_count(email_list)
  unique_emails = Set.new

  email_list.each do |email|
    local, domain = email.split('@')
    local = local.gsub('.', '')
    local = local.split('+').first if local.include?('+')
    unique_emails.add("#{local}@#{domain}")
  end

  unique_emails.size
end

puts email_count(addres_list1) # 1
puts email_count(addres_list2) # 1
puts email_count(addres_list3) # 2
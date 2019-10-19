findAccountByIds
===
    select * from account where name like #'%'+name+'%'#
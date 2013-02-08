insert into user (Host, User, Password)
values ('localhost', 'smartshop', password('smartshop01'));
insert into db (Host, Db, User, Select_priv, Insert_priv,
Update_priv, Delete_priv) values ('localhost', 'smartshop', 'smartshop',
'Y', 'Y', 'Y', 'Y');
grant CREATE on smartshop.* to smartshop@localhost;
grant ALTER on smartshop.* to smartshop@localhost;
grant DROP on smartshop.* to smartshop@localhost;
flush privileges;
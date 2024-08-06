insert into
    users (email, password)
values
    ('admin@email.com', '{noop}adminpass'),
    ('user@email.com', '{noop}userpass'),
    ('editor@email.com', '{noop}editorpass');

insert into
    user_role (name, description)
values
    ('ADMIN', 'pełne uprawnienia'),
    ('USER', 'podstawowe uprawnienia, możliwość oddawania głosów'),
    ('EDITOR', 'podstawowe uprawnienia + możliwość zarządzania treściami');

insert into
    user_roles (user_id, role_id)
values
    (1, 1),
    (2, 2),
    (3, 3);
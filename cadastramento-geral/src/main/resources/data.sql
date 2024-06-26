INSERT INTO Cliente (nome,email)
VALUES
    ('Lindomar', 'lindomar@email.com'),
    ('Otavio', 'otavio@email.com'),
    ('Isadora', 'isadora@email.com'),
    ('João Antonio', 'joao@email.com'),
    ('Julio','julio@email.com');

INSERT INTO Aplicativo (nome_app, custo_mensal)
VALUES
    ('TodoApp', 9.99),
    ('FitnessPro', 19.99),
    ('RecipeMaster', 7.99),
    ('TravelBuddy', 14.99),
    ('LearnLang', 29.99);

INSERT INTO Assinatura (cod_app, cod_cli, data_criacao, data_expiracao, status)
VALUES
    (1,5, '2024-03-06', '2024-04-06', 'CANCELADA'),
    (2,4, '2024-04-12', '2024-05-12', 'CANCELADA'),
    (2,3, '2024-05-24', '2024-06-24', 'CANCELADA'),
    (3,1, '2024-06-02', '2024-07-02', 'ATIVA'),
    (4,5, '2024-06-25', '2024-07-25', 'ATIVA');
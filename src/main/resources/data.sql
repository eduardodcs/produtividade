INSERT INTO FUNCIONARIO(nome, data_criacao, status) VALUES ('Eduardo', '2021-07-05 18:00:00', 'ATIVO');
INSERT INTO FUNCIONARIO(nome, data_criacao, status) VALUES ('Renaria', '2021-07-05 18:00:00', 'ATIVO');
INSERT INTO FUNCIONARIO(nome, data_criacao, status) VALUES ('Fernando', '2021-07-05 18:00:00', 'ATIVO');
INSERT INTO FUNCIONARIO(nome, data_criacao, status) VALUES ('Fabiana', '2021-07-05 18:00:00', 'ATIVO');
INSERT INTO FUNCIONARIO(nome, data_criacao, status) VALUES ('Alex', '2021-07-05 18:00:00', 'ATIVO');

INSERT INTO TIPO_SERVICO(descricao, data_criacao, status, meta) VALUES ('Espaçamento', '2021-07-05 18:00:00', 'ATIVO', 250);
INSERT INTO TIPO_SERVICO(descricao, data_criacao, status, meta) VALUES ('Plantio', '2021-07-05 18:00:00', 'ATIVO', 250);
INSERT INTO TIPO_SERVICO(descricao, data_criacao, status, meta) VALUES ('Puxar Carrinho', '2021-07-05 18:00:00', 'ATIVO', 250);
INSERT INTO TIPO_SERVICO(descricao, data_criacao, status, meta) VALUES ('Colheita', '2021-07-05 18:00:00', 'ATIVO', 250);

INSERT INTO LANCAMENTO(data_lancamento, funcionario_id, servico_id, quantidade, hora_inicio, hora_fim, data_criacao, total_horas)
VALUES ('2021-08-01', 1, 2, 220, '9:00', '10:15', '2021-07-05 18:00:00', 1.25);
INSERT INTO LANCAMENTO(data_lancamento, funcionario_id, servico_id, quantidade, hora_inicio, hora_fim, data_criacao, total_horas)
VALUES ('2021-08-01', 2, 1, 550, '9:00', '10:30', '2021-07-05 18:00:00', 1.5);
INSERT INTO LANCAMENTO(data_lancamento, funcionario_id, servico_id, quantidade, hora_inicio, hora_fim, data_criacao, total_horas)
VALUES ('2021-08-01', 3, 3, 300, '9:00', '9:30', '2021-07-05 18:00:00', 1.5);
INSERT INTO LANCAMENTO(data_lancamento, funcionario_id, servico_id, quantidade, hora_inicio, hora_fim, data_criacao, total_horas)
VALUES ('2021-08-01', 3, 3, 900, '9:00', '9:30', '2021-07-05 18:00:00', 1.5);
INSERT INTO LANCAMENTO(data_lancamento, funcionario_id, servico_id, quantidade, hora_inicio, hora_fim, data_criacao, total_horas)
VALUES ('2021-08-01', 3, 3, 800, '9:00', '9:30', '2021-07-05 18:00:00', 1.5);
INSERT INTO LANCAMENTO(data_lancamento, funcionario_id, servico_id, quantidade, hora_inicio, hora_fim, data_criacao, total_horas)
VALUES ('2021-08-01', 3, 3, 800, '9:00', '9:30', '2021-07-05 18:00:00', 1.5);
INSERT INTO LANCAMENTO(data_lancamento, funcionario_id, servico_id, quantidade, hora_inicio, hora_fim, data_criacao, total_horas)
VALUES ('2021-08-01', 3, 3, 500, '9:00', '9:30', '2021-07-05 18:00:00', 1.5);
INSERT INTO LANCAMENTO(data_lancamento, funcionario_id, servico_id, quantidade, hora_inicio, hora_fim, data_criacao, total_horas)
VALUES ('2021-08-01', 3, 2, 300, '9:00', '9:30', '2021-07-05 18:00:00', 1.5);
INSERT INTO LANCAMENTO(data_lancamento, funcionario_id, servico_id, quantidade, hora_inicio, hora_fim, data_criacao, total_horas)
VALUES ('2021-08-02', 3, 1, 300, '9:00', '9:30', '2021-07-05 18:00:00', 1.5);
INSERT INTO LANCAMENTO(data_lancamento, funcionario_id, servico_id, quantidade, hora_inicio, hora_fim, data_criacao, total_horas)
VALUES ('2021-08-02', 3, 3, 350, '9:00', '9:30', '2021-07-05 18:00:00', 1.5);
INSERT INTO LANCAMENTO(data_lancamento, funcionario_id, servico_id, quantidade, hora_inicio, hora_fim, data_criacao, total_horas)
VALUES ('2021-08-03', 3, 1, 300, '9:00', '9:30', '2021-07-05 18:00:00', 1.5);
INSERT INTO LANCAMENTO(data_lancamento, funcionario_id, servico_id, quantidade, hora_inicio, hora_fim, data_criacao, total_horas)
VALUES ('2021-08-03', 3, 3, 300, '9:00', '9:30', '2021-07-05 18:00:00', 1.5);
INSERT INTO LANCAMENTO(data_lancamento, funcionario_id, servico_id, quantidade, hora_inicio, hora_fim, data_criacao, total_horas)
VALUES ('2021-08-04', 3, 3, 300, '9:00', '9:30', '2021-07-05 18:00:00', 1.5);
INSERT INTO LANCAMENTO(data_lancamento, funcionario_id, servico_id, quantidade, hora_inicio, hora_fim, data_criacao, total_horas)
VALUES ('2021-08-04', 3, 2, 300, '9:00', '9:30', '2021-07-05 18:00:00', 1.5);
INSERT INTO LANCAMENTO(data_lancamento, funcionario_id, servico_id, quantidade, hora_inicio, hora_fim, data_criacao, total_horas)
VALUES ('2021-08-05', 3, 2, 300, '9:00', '9:30', '2021-07-05 18:00:00', 1.5);
INSERT INTO LANCAMENTO(data_lancamento, funcionario_id, servico_id, quantidade, hora_inicio, hora_fim, data_criacao, total_horas)
VALUES ('2021-08-05', 3, 3, 300, '9:00', '9:30', '2021-07-05 18:00:00', 1.5);


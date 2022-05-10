INSERT INTO tb_account (balance) values (1000);
INSERT INTO tb_client (name, cpf, password, id_account) values ('Eduardo Mesquita', '02445878945', 'kaduzinSenha', 1);
INSERT INTO tb_agency (name) values ('Agency 1');
UPDATE tb_account SET client_id = 1, agency_id = 1 WHERE id = 1;
INSERT INTO tb_transaction_log (date, value, type, account_id) values ('2022-01-01 00:00:01', 1000, 2, 1);
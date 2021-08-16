INSERT INTO public.usuario(id, data_atualizacao, data_criacao, email, enabled, nome, senha, ultimo_acesso) VALUES (1, now(), now(), 'admin@email.com', true, 'Administrador', '$2a$10$FFQ5DcUS4.UBrqz6o/qFzOtBP6XLW/vNd28WvTJHzZoa38vtCbYA.', null);
INSERT INTO public.usuario(id, data_atualizacao, data_criacao, email, enabled, nome, senha, ultimo_acesso) VALUES (2, now(), now(), 'amandamaiteninacaldeira-97@maptec.com.br', true, 'Amanda Maitê Nina Caldeira', '$2a$10$FFQ5DcUS4.UBrqz6o/qFzOtBP6XLW/vNd28WvTJHzZoa38vtCbYA.', null);
INSERT INTO public.usuario(id, data_atualizacao, data_criacao, email, enabled, nome, senha, ultimo_acesso) VALUES (3, now(), now(), 'kamillyjulianabrito-72@dpauladecor.com.br', true, 'Kamilly Juliana Brito', '$2a$10$FFQ5DcUS4.UBrqz6o/qFzOtBP6XLW/vNd28WvTJHzZoa38vtCbYA.', null);
INSERT INTO public.usuario(id, data_atualizacao, data_criacao, email, enabled, nome, senha, ultimo_acesso) VALUES (4, now(), now(), 'luandiogomurilorodrigues-98@lhp.com.br', true, 'Luan Diogo Murilo Rodrigues', '$2a$10$FFQ5DcUS4.UBrqz6o/qFzOtBP6XLW/vNd28WvTJHzZoa38vtCbYA.', null);
INSERT INTO public.usuario(id, data_atualizacao, data_criacao, email, enabled, nome, senha, ultimo_acesso) VALUES (5, now(), now(), 'bbeneditafatimadarosa@delfrateinfo.com.br', true, 'Benedita Fátima da Rosa', '$2a$10$FFQ5DcUS4.UBrqz6o/qFzOtBP6XLW/vNd28WvTJHzZoa38vtCbYA.', null);


INSERT INTO public.perfil(id, nome)	VALUES (1, 'ADMIN');
INSERT INTO public.perfil(id, nome)	VALUES (2, 'USER');

INSERT INTO public.usuario_perfis(usuario_id, perfis_id) VALUES (1, 1);
INSERT INTO public.usuario_perfis(usuario_id, perfis_id) VALUES (1, 2);
INSERT INTO public.usuario_perfis(usuario_id, perfis_id) VALUES (2, 2);
INSERT INTO public.usuario_perfis(usuario_id, perfis_id) VALUES (3, 2);
INSERT INTO public.usuario_perfis(usuario_id, perfis_id) VALUES (4, 2);
INSERT INTO public.usuario_perfis(usuario_id, perfis_id) VALUES (5, 2);

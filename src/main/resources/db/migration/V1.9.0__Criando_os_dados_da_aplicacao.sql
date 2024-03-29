INSERT INTO public.post(id, data_atualizacao, data_criacao, texto, id_usuario) VALUES (1, now(), now(), 'Massa ultrices per tincidunt eu aliquet ut lectus, metus odio metus rhoncus purus luctus, ad hendrerit tincidunt lobortis placerat felis.', 2);
INSERT INTO public.post(id, data_atualizacao, data_criacao, texto, id_usuario) VALUES (2, now(), now(), 'Gravida justo vel faucibus porttitor sagittis enim senectus curabitur semper, congue dolor vitae donec ante aliquam potenti sapien inceptos sodales, erat vulputate faucibus ultricies vel non ad felis. sociosqu feugiat lorem mattis turpis praesent in fames, dictumst nam potenti suscipit tellus faucibus mi molestie, leo tempus elit curabitur adipiscing nostra. ', 2);
INSERT INTO public.post(id, data_atualizacao, data_criacao, texto, id_usuario) VALUES (3, now(), now(), 'Habitasse vehicula eu elit donec vivamus rhoncus senectus, scelerisque nullam leo cras rhoncus per, augue proin sollicitudin condimentum accumsan dapibus. suspendisse quisque fusce potenti ullamcorper vehicula felis aliquet senectus, placerat convallis feugiat enim neque quis consequat torquent diam, aliquet ut nostra hac dictumst accumsan lacus. gravida dictum interdum blandit, vestibulum. ', 3);
INSERT INTO public.post(id, data_atualizacao, data_criacao, texto, id_usuario) VALUES (4, now(), now(), 'Pellentesque commodo litora libero etiam sollicitudin curabitur faucibus fringilla malesuada taciti, curabitur fames justo feugiat aptent et condimentum sodales orci, rhoncus nam sociosqu aliquam arcu id gravida lacus interdum. pretium curabitur id molestie mi consequat inceptos, nostra cursus urna mi magna, lectus auctor nullam erat duis. lorem quam tempus, aenean. ', 3);
INSERT INTO public.post(id, data_atualizacao, data_criacao, texto, id_usuario) VALUES (5, now(), now(), 'Pharetra egestas fringilla odio bibendum ornare, augue vestibulum class sed. ', 4);
INSERT INTO public.post(id, data_atualizacao, data_criacao, texto, id_usuario) VALUES (6, now(), now(), 'Sagittis duis quisque placerat sem mollis, feugiat lectus euismod metus.', 4);
INSERT INTO public.post(id, data_atualizacao, data_criacao, texto, id_usuario) VALUES (7, now(), now(), 'Aptent praesent molestie primis augue himenaeos morbi sollicitudin, lacinia habitant tempor maecenas odio metus, ante ut consequat placerat pharetra donec.', 5);
INSERT INTO public.post(id, data_atualizacao, data_criacao, texto, id_usuario) VALUES (8, now(), now(), 'Placerat pharetra nunc viverra habitant maecenas sed platea ultrices etiam quisque, tellus aliquam condimentum vehicula fermentum accumsan lectus diam eros. ', 5);
INSERT INTO public.post(id, data_atualizacao, data_criacao, texto, id_usuario) VALUES (9, now(), now(), 'Hac erat sollicitudin viverra, justo. ', 5);

INSERT INTO public.comentario(id, data_atualizacao, data_criacao, texto, id_post, id_usuario) VALUES (1, now(), now(), 'Aenean egestas nec vehicula habitasse proin, pharetra nec gravida quisque.', 1, 2);
INSERT INTO public.comentario(id, data_atualizacao, data_criacao, texto, id_post, id_usuario) VALUES (2, now(), now(), 'Erat tincidunt vestibulum suspendisse quisque mauris, magna placerat faucibus arcu.', 1, 2);
INSERT INTO public.comentario(id, data_atualizacao, data_criacao, texto, id_post, id_usuario) VALUES (3, now(), now(), 'Pellentesque posuere eleifend iaculis himenaeos feugiat, viverra etiam massa diam.', 1, 2);
INSERT INTO public.comentario(id, data_atualizacao, data_criacao, texto, id_post, id_usuario) VALUES (4, now(), now(), 'Dolor erat platea interdum pretium nulla, vestibulum aptent mauris ornare.', 1, 3);
INSERT INTO public.comentario(id, data_atualizacao, data_criacao, texto, id_post, id_usuario) VALUES (5, now(), now(), 'Scelerisque posuere scelerisque auctor lacus ultricies, risus morbi suspendisse integer.', 1, 3);
INSERT INTO public.comentario(id, data_atualizacao, data_criacao, texto, id_post, id_usuario) VALUES (6, now(), now(), 'Orci curabitur commodo venenatis sem conubia, dolor inceptos velit senectus.', 1, 4);
INSERT INTO public.comentario(id, data_atualizacao, data_criacao, texto, id_post, id_usuario) VALUES (7, now(), now(), 'Aliquet donec a aliquet cursus sollicitudin, diam risus tortor habitasse.', 1, 4);
INSERT INTO public.comentario(id, data_atualizacao, data_criacao, texto, id_post, id_usuario) VALUES (8, now(), now(), 'Sodales mattis nunc erat mi etiam, aliquam porta accumsan luctus.', 1, 5);
INSERT INTO public.comentario(id, data_atualizacao, data_criacao, texto, id_post, id_usuario) VALUES (9, now(), now(), 'Quis duis habitasse ligula, eros class imperdiet faucibus, aptent ornare.', 1, 5);

INSERT INTO public.imagem(id, arquivo, data_criacao, path, titulo, id_post)	VALUES (1, 'quadro-tela-paisagens-natureza-praia-coqueiro-mar-areia-004-quadro-tela.jpg', now(), 'https://img.elo7.com.br/product/zoom/1C340F5/quadro-tela-paisagens-natureza-praia-coqueiro-mar-areia-004-quadro-tela.jpg', 'Platea donec faucibus', 1);
INSERT INTO public.imagem(id, arquivo, data_criacao, path, titulo, id_post)	VALUES (2, 'vistamorro-1280x640.jpg', now(), 'http://www.construtoraconcisa.com.br/blog/wp-content/uploads/2019/10/vistamorro-1280x640.jpg', 'Vel fermentum facilisis', 1);
INSERT INTO public.imagem(id, arquivo, data_criacao, path, titulo, id_post)	VALUES (3, 'foz-do-iguacu-cataratas-e1526566331277.jpg', now(), 'https://www.melhoresdestinos.com.br/wp-content/uploads/2017/06/foz-do-iguacu-cataratas-e1526566331277.jpg', 'Sapien curabitur vel', 2);
INSERT INTO public.imagem(id, arquivo, data_criacao, path, titulo, id_post)	VALUES (4, 'castelos-na-alemanha.jpg', now(), 'https://www.queroviajarmais.com/wp-content/uploads/2020/08/castelos-na-alemanha.jpg', null, 2);
INSERT INTO public.imagem(id, arquivo, data_criacao, path, titulo, id_post)	VALUES (5, '365_240_essas-sao-as-paisagens-mais-bonitas-do-brasil-04.jpg', now(), 'https://www.grupoescolar.com/thumbnail-image/365_240_essas-sao-as-paisagens-mais-bonitas-do-brasil-04.jpg', 'Sociosqu senectus curabitur', 3);
INSERT INTO public.imagem(id, arquivo, data_criacao, path, titulo, id_post)	VALUES (6, 'talvez.jpg', now(), 'https://www.specialtrip.com.br/wp-content/uploads/2018/03/talvez.jpg', 'Quisque fringilla lorem', 3);
INSERT INTO public.imagem(id, arquivo, data_criacao, path, titulo, id_post)	VALUES (7, 'africa2-5344813.jpg', now(), 'http://midias.gazetaonline.com.br/_midias/jpg/2017/10/27/africa2-5344813.jpg', 'Egestas sed iaculis', 4);
INSERT INTO public.imagem(id, arquivo, data_criacao, path, titulo, id_post)	VALUES (8, 'DeadVlei-Sossusvlei-Namibia-Elaine-Villatoro.png', now(), 'https://content.skyscnr.com/m/5282e8d697ad414a/original/DeadVlei-Sossusvlei-Namibia-Elaine-Villatoro.png?resize=1800px:1800px&quality=100', 'Mauris lacinia nec', 5);
INSERT INTO public.imagem(id, arquivo, data_criacao, path, titulo, id_post)	VALUES (9, 'Paisagens-Noruega-1-09.jpg', now(), 'https://maironpelomundo.com/wp-content/uploads/2020/08/Paisagens-Noruega-1-09.jpg', 'Litora quis placerat', 5);

INSERT INTO public.link(id, data_atualizacao, data_criacao, url, titulo, id_post) VALUES (1, now(), now(), 'https://www.viagem20.com.br/paginas-textuais/videos-1', 'Vídeos Tutoriais | Viagem 2.0', 1);
INSERT INTO public.link(id, data_atualizacao, data_criacao, url, titulo, id_post) VALUES (2, now(), now(), 'https://www.techtudo.com.br/dicas-e-tutoriais/2019/12/como-fazer-roteiro-de-viagem-no-celular-com-o-onde-ir.ghtml', 'Como fazer roteiro de viagem no celular com o Onde', 1);
INSERT INTO public.link(id, data_atualizacao, data_criacao, url, titulo, id_post) VALUES (3, now(), now(), 'https://promocaopacotesviagens.com.br/video-tutorial-de-como-fazer-sua-mala-de-viagem', 'Video Tutorial de como fazer sua mala de viagem', 2);
INSERT INTO public.link(id, data_atualizacao, data_criacao, url, titulo, id_post) VALUES (4, now(), now(), 'https://www.hostinger.com.br/tutoriais/como-fazer-um-blog-de-viagem', 'Como fazer um blog de viagem do zero (6 passos) - Hostinger', 2);
INSERT INTO public.link(id, data_atualizacao, data_criacao, url, titulo, id_post) VALUES (5, now(), now(), 'https://www.youtube.com/watch?v=23-__F9Df_I', 'Como PLANEJAR um vídeo ou vlog de VIAGEM - YouTube', 3);
INSERT INTO public.link(id, data_atualizacao, data_criacao, url, titulo, id_post) VALUES (6, now(), now(), 'https://assistentedeviagem.com.br/seguro-viagem/video-tutorial', 'Assistente de Viagem - Vídeo Tutorial - Seguro Viagem', 3);
INSERT INTO public.link(id, data_atualizacao, data_criacao, url, titulo, id_post) VALUES (7, now(), now(), 'https://www.udemy.com/course/faca-ja-seu-blog-de-viagens/', 'Tutorial de Blogging grátis - Faça já Seu Blog De Viagens', 4);
INSERT INTO public.link(id, data_atualizacao, data_criacao, url, titulo, id_post) VALUES (8, now(), now(), 'https://www.viajenaviagem.com/2011/12/como-montar-viagem-europa/', 'Como montar sua viagem à Europa | Ricardo Freire | Viaje na', 5);
INSERT INTO public.link(id, data_atualizacao, data_criacao, url, titulo, id_post) VALUES (9, now(), now(), 'https://portal.londrina.pr.gov.br/despesas-de-viagens', 'Despesas de Viagens - Portal da Prefeitura de Londrina', 5);

INSERT INTO public.album(id, data_atualizacao, data_criacao, descricao, titulo, id_usuario)	VALUES (1, now(), now(), 'Est arcu leo volutpat, vehicula.', 'Ante consectetur lorem', 2);
INSERT INTO public.album(id, data_atualizacao, data_criacao, descricao, titulo, id_usuario)	VALUES (2, now(), now(), 'Auctor ipsum hendrerit pellentesque, imperdiet.', 'Tellus placerat orci', 3);
INSERT INTO public.album(id, data_atualizacao, data_criacao, descricao, titulo, id_usuario)	VALUES (3, now(), now(), null, 'Ad quis eleifend', 3);
INSERT INTO public.album(id, data_atualizacao, data_criacao, descricao, titulo, id_usuario)	VALUES (4, now(), now(), 'Sit leo curae sit, posuere.', 'Nunc pharetra quisque', 4);
INSERT INTO public.album(id, data_atualizacao, data_criacao, descricao, titulo, id_usuario)	VALUES (5, now(), now(), 'Pulvinar purus vulputate lacus, sociosqu.', 'Senectus volutpat amet', 5);

INSERT INTO public.foto(id, arquivo, data_criacao, path, id_album) VALUES (1, '20thykzikzvos.jpg', now(), 'https://cdn6.campograndenews.com.br/uploads/noticias/2020/03/10/20thykzikzvos.jpg', 1);
INSERT INTO public.foto(id, arquivo, data_criacao, path, id_album) VALUES (2, 'dicas-para-viagens-internacionais.jpg', now(), 'https://www.segurospromo.com.br/blog/wp-content/uploads/2016/11/dicas-para-viagens-internacionais.jpg', 1);
INSERT INTO public.foto(id, arquivo, data_criacao, path, id_album) VALUES (3, 'gest%C3%A3o-de-viagens-corporativas-e1551120312194.jpg', now(), 'https://tristarturismo.com.br/wp-content/uploads/2019/02/gest%C3%A3o-de-viagens-corporativas-e1551120312194.jpg', 2);
INSERT INTO public.foto(id, arquivo, data_criacao, path, id_album) VALUES (4, 'viagens-de-incentivo-praia-ou-interior-saiba-aqui-o-melhor-destino27236.jpg', now(), 'https://topservicetur.com.br/wp-content/uploads/2016/09/viagens-de-incentivo-praia-ou-interior-saiba-aqui-o-melhor-destino27236.jpg', 2);
INSERT INTO public.foto(id, arquivo, data_criacao, path, id_album) VALUES (5, '2b2d26ed61c6daccaf6ca2a5fd69f933.jpg', now(), 'https://images.memphistours.com/xlarge/2b2d26ed61c6daccaf6ca2a5fd69f933.jpg', 3);
INSERT INTO public.foto(id, arquivo, data_criacao, path, id_album) VALUES (6, 'viagem-mundo.jpg', now(), 'https://s2.glbimg.com/5hafajgJR2Tr2ghwFklOEVmm-lo=/620x455/e.glbimg.com/og/ed/f/original/2019/01/09/viagem-mundo.jpg', 3);
INSERT INTO public.foto(id, arquivo, data_criacao, path, id_album) VALUES (7, 'Viagem.jpg', now(), 'https://www.mercadoeeventos.com.br/wp-content/uploads/2016/08/Viagem.jpg', 4);
INSERT INTO public.foto(id, arquivo, data_criacao, path, id_album) VALUES (8, 'Viagens-Baratas-1-740x415.jpg', now(), 'https://www.passagenspromo.com.br/blog/wp-content/uploads/2018/11/Viagens-Baratas-1-740x415.jpg', 4);
INSERT INTO public.foto(id, arquivo, data_criacao, path, id_album) VALUES (9, 'onde-comprar-pacote-de-viagens.jpg', now(), 'https://cdnstatic8.com/viagenspelomundo.com.br/wp-content/uploads/2021/05/onde-comprar-pacote-de-viagens.jpg', 5);

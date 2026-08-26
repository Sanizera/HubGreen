USE hubgreen;


-- =========================================================
-- ESTADO
-- =========================================================

INSERT INTO estado (id, nome, sigla) VALUES
(1, 'Santa Catarina', 'SC'),
(2, 'Paraná', 'PR'),
(3, 'Rio Grande do Sul', 'RS'),
(4, 'São Paulo', 'SP'),
(5, 'Rio de Janeiro', 'RJ');


-- =========================================================
-- CIDADE
-- =========================================================

INSERT INTO cidade (id, cidade, estado_id) VALUES
(1, 'Florianópolis', 1),
(2, 'Joinville', 1),
(3, 'Curitiba', 2),
(4, 'Porto Alegre', 3),
(5, 'São Paulo', 4),
(6, 'Rio de Janeiro', 5),
(7, 'Blumenau', 1),
(8, 'Londrina', 2);


-- =========================================================
-- CATEGORIA
-- =========================================================

INSERT INTO categoria (id, nome) VALUES
(1, 'Alimentos Orgânicos'),
(2, 'Cosméticos Naturais'),
(3, 'Artesanato Sustentável'),
(4, 'Moda Sustentável'),
(5, 'Tecnologia Verde'),
(6, 'Produtos Reciclados');


-- =========================================================
-- EXPOSITOR
-- =========================================================

INSERT INTO expositor (id, nome, biografia) VALUES
(
    1,
    'EcoVida Alimentos',
    'Empresa especializada na produção de alimentos orgânicos e produtos naturais.'
),
(
    2,
    'Verde Essência',
    'Marca de cosméticos naturais produzidos com ingredientes de origem sustentável.'
),
(
    3,
    'Arte da Terra',
    'Coletivo de artesãos que utiliza materiais naturais e reaproveitados em seus produtos.'
),
(
    4,
    'Raízes da Moda',
    'Marca de moda sustentável focada em tecidos ecológicos e produção consciente.'
),
(
    5,
    'GreenTech Solutions',
    'Empresa dedicada ao desenvolvimento de tecnologias para eficiência energética e sustentabilidade.'
),
(
    6,
    'Recria Design',
    'Estúdio especializado na criação de produtos utilizando materiais reciclados.'
);


-- =========================================================
-- EVENTO
-- =========================================================

INSERT INTO evento
(id, nome, local, cidade_id, data, status, descricao)
VALUES
(
    1,
    'ExpoGreen Florianópolis 2026',
    'CentroSul',
    1,
    '2026-09-15 09:00:00',
    'em andamento',
    'Feira de inovação, sustentabilidade e produtos ecológicos.'
),
(
    2,
    'Festival Verde de Joinville',
    'Expoville',
    2,
    '2026-10-10 10:00:00',
    'em andamento',
    'Evento voltado à sustentabilidade, economia circular e consumo consciente.'
),
(
    3,
    'Green Business Curitiba',
    'Expo Unimed Curitiba',
    3,
    '2026-11-05 09:30:00',
    'em andamento',
    'Encontro de empresas e empreendedores ligados à economia verde.'
),
(
    4,
    'Sustenta RS',
    'Centro de Eventos FIERGS',
    4,
    '2026-08-01 08:30:00',
    'finalizado',
    'Feira de sustentabilidade e tecnologias ambientais do Rio Grande do Sul.'
),
(
    5,
    'São Paulo Eco Experience',
    'São Paulo Expo',
    5,
    '2026-12-12 10:00:00',
    'em andamento',
    'Experiência dedicada a soluções sustentáveis para empresas e consumidores.'
),
(
    6,
    'Rio Verde Expo',
    'Riocentro',
    6,
    '2027-01-20 09:00:00',
    'em andamento',
    'Evento nacional de sustentabilidade, inovação e economia circular.'
);


-- =========================================================
-- EVENTO_EXPOSITOR
-- =========================================================

INSERT INTO evento_expositor
(id, evento_id, expositor_id, status)
VALUES
(1, 1, 1, 'ativo'),
(2, 1, 2, 'ativo'),
(3, 1, 3, 'ativo'),
(4, 2, 2, 'ativo'),
(5, 2, 4, 'ativo'),
(6, 2, 6, 'ativo'),
(7, 3, 1, 'ativo'),
(8, 3, 5, 'ativo'),
(9, 3, 4, 'cancelado'),
(10, 4, 3, 'ativo'),
(11, 4, 5, 'ativo'),
(12, 5, 4, 'ativo'),
(13, 5, 6, 'ativo'),
(14, 5, 5, 'ativo'),
(15, 6, 1, 'ativo');


-- =========================================================
-- EXPOSITOR_IMAGENS
-- URLs COMPLETAS
-- =========================================================

INSERT INTO expositor_imagens
(id, expositor_id, caminho, data, tipo)
VALUES
(
    1,
    1,
    'https://images.unsplash.com/photo-1542838132-92c53300491e?w=800&q=80',
    '2026-07-01 10:00:00',
    'perfil'
),
(
    2,
    1,
    'https://images.unsplash.com/photo-1488459716781-31db52582fe9?w=800&q=80',
    '2026-07-02 11:00:00',
    'outras'
),
(
    3,
    2,
    'https://images.unsplash.com/photo-1556228578-8c89e6adf883?w=800&q=80',
    '2026-07-03 09:30:00',
    'perfil'
),
(
    4,
    3,
    'https://images.unsplash.com/photo-1452860606245-08befc0ff44b?w=800&q=80',
    '2026-07-04 14:00:00',
    'perfil'
),
(
    5,
    4,
    'https://images.unsplash.com/photo-1483985988355-763728e1935b?w=800&q=80',
    '2026-07-05 15:00:00',
    'perfil'
),
(
    6,
    5,
    'https://images.unsplash.com/photo-1473341304170-971dccb5ac1e?w=800&q=80',
    '2026-07-06 16:30:00',
    'perfil'
),
(
    7,
    6,
    'https://images.unsplash.com/photo-1531058020387-3be344556be6?w=800&q=80',
    '2026-07-07 13:00:00',
    'perfil'
),
(
    8,
    6,
    'https://images.unsplash.com/photo-1513506003901-1e6a229e2d15?w=800&q=80',
    '2026-07-08 13:30:00',
    'outras'
);


-- =========================================================
-- PRODUTO
-- =========================================================

INSERT INTO produto
(id, produto, descricao, expositor_id, imagem, valor, categoria_id)
VALUES
(
    1,
    'Cesta Orgânica Premium',
    'Cesta com frutas, verduras e legumes produzidos sem agrotóxicos.',
    1,
    'https://images.unsplash.com/photo-1610832958506-aa56368176cf?w=800&q=80',
    89.90,
    1
),
(
    2,
    'Sabonete Natural de Lavanda',
    'Sabonete artesanal produzido com óleos essenciais e ingredientes naturais.',
    2,
    'https://images.unsplash.com/photo-1607006344380-b6775a0824f7?w=800&q=80',
    24.90,
    2
),
(
    3,
    'Vaso de Fibra Natural',
    'Vaso decorativo produzido artesanalmente com fibras naturais.',
    3,
    'https://images.unsplash.com/photo-1485955900006-10f4d324d411?w=800&q=80',
    59.90,
    3
),
(
    4,
    'Camiseta Algodão Orgânico',
    'Camiseta produzida com algodão orgânico e tingimento de baixo impacto.',
    4,
    'https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?w=800&q=80',
    119.90,
    4
),
(
    5,
    'Kit Sensor de Energia Solar',
    'Kit para monitoramento do consumo e geração de energia solar.',
    5,
    'https://images.unsplash.com/photo-1509391366360-2e959784a276?w=800&q=80',
    349.90,
    5
),
(
    6,
    'Luminária de Material Reciclado',
    'Luminária decorativa produzida a partir de materiais reciclados.',
    6,
    'https://images.unsplash.com/photo-1507473885765-e6ed057f782c?w=800&q=80',
    149.90,
    6
),
(
    7,
    'Granola Orgânica',
    'Granola artesanal produzida com ingredientes orgânicos.',
    1,
    'https://images.unsplash.com/photo-1517093728432-0a2d2d2e9c6b?w=800&q=80',
    32.50,
    1
),
(
    8,
    'Hidratante Corporal Natural',
    'Hidratante corporal produzido com manteigas e óleos vegetais.',
    2,
    'https://images.unsplash.com/photo-1611930022073-b7a4ba5fcccd?w=800&q=80',
    48.90,
    2
),
(
    9,
    'Bolsa de Material Reciclado',
    'Bolsa artesanal produzida utilizando materiais reaproveitados.',
    6,
    'https://images.unsplash.com/photo-1594223274512-ad4803739b7c?w=800&q=80',
    79.90,
    6
),
(
    10,
    'Tênis de Fibra Sustentável',
    'Calçado produzido com materiais de baixo impacto ambiental.',
    4,
    'https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=800&q=80',
    299.90,
    4
);


-- =========================================================
-- EVENTO_IMAGENS
-- URLs COMPLETAS
-- =========================================================

INSERT INTO evento_imagens
(id, evento_id, caminho, data)
VALUES
(
    1,
    1,
    'https://images.unsplash.com/photo-1505373877841-8d25f7d46678?w=1200&q=80',
    '2026-07-15 10:00:00'
),
(
    2,
    1,
    'https://images.unsplash.com/photo-1492684223066-81342ee5ff30?w=1200&q=80',
    '2026-07-15 10:30:00'
),
(
    3,
    2,
    'https://images.unsplash.com/photo-1540575467063-178a50c2df87?w=1200&q=80',
    '2026-07-20 09:00:00'
),
(
    4,
    3,
    'https://images.unsplash.com/photo-1505236858219-8359eb29e329?w=1200&q=80',
    '2026-07-25 11:00:00'
),
(
    5,
    4,
    'https://images.unsplash.com/photo-1511578314322-379afb476865?w=1200&q=80',
    '2026-08-02 14:00:00'
),
(
    6,
    5,
    'https://images.unsplash.com/photo-1505373877841-8d25f7d46678?w=1200&q=80',
    '2026-08-05 15:00:00'
),
(
    7,
    6,
    'https://images.unsplash.com/photo-1501281668745-f7f57925c3b4?w=1200&q=80',
    '2026-08-10 16:00:00'
),
(
    8,
    6,
    'https://images.unsplash.com/photo-1492684223066-81342ee5ff30?w=1200&q=80',
    '2026-08-10 16:30:00'
);

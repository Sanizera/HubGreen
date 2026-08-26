SELECT
    e.id,
    e.nome,
    e.local,
    c.cidade,
    est.nome AS estado,
    est.sigla,
    e.data,
    e.status,
    e.descricao
FROM evento e
INNER JOIN cidade c
    ON c.id = e.cidade_id
INNER JOIN estado est
    ON est.id = c.estado_id
ORDER BY e.data DESC;

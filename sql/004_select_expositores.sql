SELECT
    ex.id,
    ex.nome,
    ex.biografia,
    ev.nome,
    ee.status
FROM evento_expositor ee
INNER JOIN expositor ex
    ON ex.id = ee.expositor_id
INNER JOIN evento ev
	ON ev.id = ee.evento_id
WHERE ee.evento_id = 1
  AND ee.status = 'ativo'
ORDER BY ex.nome;

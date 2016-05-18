xquery version "3.0";

for $tipo_especie in distinct-values(doc("Abedemon.xml")/bd-abedemon//especie/tipo)
order by $tipo_especie
return $tipo_especie
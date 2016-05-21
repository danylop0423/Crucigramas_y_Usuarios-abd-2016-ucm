declare variable $tipo as xs:string external;

for $especie in doc("Abedemon.xml")/bd-abedemon//especie[tipo = $tipo]
return <resultado id="{ $especie/@id }" nombre="{ $especie/nombre }" num-ataques="{ $especie/ataques/count(tiene-ataque) }" />

declare variable $id as xs:string external;
declare variable $adversario_id as xs:string external;

let $adversario_tipos := data(doc("Abedemon.xml")/bd-abedemon//especie[@id = $adversario_id]/tipo)
let $ataques_id := data(doc("Abedemon.xml")/bd-abedemon//especie[@id = $id]/ataques/tiene-ataque/@id)
let $ataques := doc("Abedemon.xml")/bd-abedemon/ataque[@id = $ataques_id]
return data(max($ataques/daño[@tipo = $adversario_tipos]/@valor))
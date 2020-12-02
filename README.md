# g6s2-cvda-projet-bbombardella

- BOMBARDELLA Bastien
- bastien.bombardella@etu.univ-lyon1.fr
- Niveau en JAVA : confortable
- https://g6s2-2020-iut-lyon1.framaboard.org/kanboard/?controller=BoardViewController&action=show&project_id=3&search=status%3Aopen
- https://docs.kanboard.org/fr/latest/index.html
- [Edition du diagramme d'activité](http://yuml.me/bastienbc/edit/969ee675) : http://yuml.me/bastienbc/edit/969ee675
- Coordonnées du binôme :
    - DAUBIGIE Marina
    - marina.daubigie@etu.univ-lyon1.fr
    - https://forge.univ-lyon1.fr/p1617728/g6s2-cvda-projet-mdaubigie

![Diagramme d'activité UML](https://yuml.me/bastienbc/969ee675.png)

```
(start)->(Je me connecte a la forge)-><a>[J'ai reussi a me connecter]->(Je telecharge mes projets)-><b>[Il y a des projets existants]->(Je choisis le format)-><c>[PDF]->(Exportation en PDF)->|a|
<c>[XML]->(Exportation en XML)->|a|
<c>[JSON]->(Exportation en JSON)->|a|
<c>[HTML]->(Exportation en HTML)->|a|
|a|->(Telechargement de l'exportation)->(end)
<b>[Aucun projet existants]->(Message d'erreur
aucun projet existant)->(end)
<a>[Je n'ai pas reussi a me connecter]->(Message d'erreur concernant la connexion)->(end)
```
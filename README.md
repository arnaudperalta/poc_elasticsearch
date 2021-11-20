# Preuve de concept Elastic - Projet BIOllca

## Installation
```
$ docker-compose up -d
```

### IP API : `http//localhost:8080/api`

### IP DB : `http//localhost:9200`

## Utilisation

Une collection postman est disponible dans le fichier `PoC_Elasticsearch.postman_collection.json`

Une fois importé, il faudra exécuter au minimum les requêtes suivantes dans cet ordre :

- `POST /user` : Pour la création des utilisateurs qui seront filtrés dans le futur et leur stockage en base.
- `POST /filter` : Pour la création d'un filtre comme le body de la requête le défini et son stockage en base.
- `POST /filter/user` : Pour l'exécution du filtre sur les utilisateurs.

La visualisation des différentes entités dans la base Elasticsearch sont possibles avec ces deux routes :
- `GET /filter`
- `GET /user`

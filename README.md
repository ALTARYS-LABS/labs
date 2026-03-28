# Altarys Labs

Une collection de tutoriels pratiques et d'exemples de code pour l'équipe technique d'Altarys.
Chaque tutoriel est un projet autonome dans son propre dossier.

## Tutoriels

| Dossier | Sujet | Stack |
|---------|-------|-------|
| [spring-application-events](./spring-application-events) | Découpler ses services avec les Spring Application Events | Java 25 · Spring Boot 4 |

## Comment utiliser ce dépôt

Cloner le dépôt une seule fois pour tout avoir :

```bash
git clone git@github.com:ALTARYS-LABS/labs.git
```

Puis naviguer vers le tutoriel souhaité :

```bash
cd labs/spring-application-events
./gradlew bootRun
```

Chaque dossier de tutoriel contient son propre `README.md` avec les instructions de lancement et les objectifs pédagogiques.

## Ajouter un nouveau tutoriel

1. Développer le projet où vous le souhaitez sur votre machine
2. Copier les sources (sans les artefacts de build) dans ce dépôt :
   ```bash
   rsync -a --exclude='build/' --exclude='.gradle/' --exclude='.idea/' \
     /chemin/vers/mon-projet/ \
     /Users/eblonvia/dev/workspace/labs/altarys/altaryslabs/nom-du-tutoriel/
   ```
3. Ajouter un `README.md` dans le nouveau dossier (objectifs, prérequis, instructions)
4. Ajouter une ligne dans le tableau **Tutoriels** ci-dessus
5. Committer et pousser :
   ```bash
   cd /Users/eblonvia/dev/workspace/labs/altarys/altaryslabs
   git add .
   git commit -m "feat: add nom-du-tutoriel tutorial"
   git push
   ```

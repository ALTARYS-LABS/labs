# Spring Application Events

**Niveau :** Junior / Mid
**Stack :** Java 25 · Spring Boot 4 · Gradle

## Ce que vous allez apprendre

Le mécanisme `ApplicationEvent` de Spring permet à des services de réagir à ce qui se passe dans l'application **sans se connaître mutuellement**. C'est le patron de conception Observer, intégré nativement dans le framework.

Sans events, un service qui enregistre un client pourrait appeler directement un service de structure d'organisation, un service d'audit, un service d'envoi d'email, etc. — accumulant des dépendances qu'il n'a pas à porter.

Avec les events, le service **publie simplement un fait** (`ClientCreationEvent`) et continue son travail. N'importe quel nombre de listeners peut réagir de façon indépendante.

## Structure de la démo

```
ClientController          → reçoit le POST HTTP, appelle ClientService, puis publie ClientCreationEvent
ClientService             → enregistre le client et le retourne
ClientCreationEvent       → un simple record portant le nom + l'email (le "fait")
OrgStructureService       → écoute ClientCreationEvent via @EventListener, réagit de façon autonome
AppEventConfig            → câble les beans manuellement (sans component scan, intentionnel pour la clarté)
```

### Classes clés

| Classe | Rôle |
|--------|------|
| `ClientCreationEvent` | L'event — un simple record, sans héritage Spring nécessaire (depuis Spring 4.2) |
| `ClientController` | Publie l'event via `ApplicationEventPublisher` |
| `OrgStructureService` | Réagit à l'event avec `@EventListener` |

## Prérequis

- Java 25
- Docker (pour le support `docker compose`, même si `compose.yaml` est vide dans cette démo)

## Lancer l'application

```bash
./gradlew bootRun
```

## Tester

Utilisez le fichier de requête HTTP inclus (`clientRequest.http`) avec le client HTTP d'IntelliJ IDEA, ou exécutez :

```bash
curl -X POST http://localhost:8080/api/v1/clients \
  -H "Content-Type: application/json" \
  -d '{"name": "James OLUWA", "email": "content@altaryslabs.com", "phone": "0736024598"}'
```

Vous devriez voir le log de réception de l'event affiché par `OrgStructureService`.

## Pistes d'exploration

- Ajoutez un deuxième `@EventListener` dans un nouveau service — remarquez que `ClientController` n'a besoin d'aucune modification
- Rendez le listener `@Async` pour traiter l'event sur un thread séparé
- Utilisez `@TransactionalEventListener` pour déclencher l'event uniquement après la validation de la transaction en base

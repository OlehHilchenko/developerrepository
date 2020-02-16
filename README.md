Практика

Необходимо реализовать консольное CRUD приложение, которое работает со следующими сущностями:
Developer
Skill
Account
AccountStatus (enum ACTIVE, BANNED, DELETED)

Developer -> Set<Skill> skills + Account account
Account -> AccountStatus

Необходимо использовать *.csv файлы для хранения данных:
developers.csv, skills.csv, accounts.csv


Cлои:
model - POJO classes
repository - доступ к файлам
controller - обработка запросов пользователя
view - взаимодействие пользователя с консолью
Пример: 
Developer, DeveloperRepository, DeveloperController, DeveloperView и т.д.
interface GenericRepository<T,ID>
interface DeveloperRepository extends GenericRepository<Developer, Long>
class JavaСsvDeveloperRepositoryImpl implements DeveloperRepository.

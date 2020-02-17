package company.jelli;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PersonService {
    private static PersonService obj;

    Map<Integer, List<Person>> departmentPersonMap;
    Map<Integer, Person> personMap;

    public synchronized static PersonService getInstance() {
        if (obj == null) {
            obj = new PersonService();
        }
        return obj;
    }

    private PersonService() {

    }

    private PersonService(List<Person> persons) {
        this.departmentPersonMap = new ConcurrentHashMap<>();
        this.personMap = new ConcurrentHashMap<>();

        for (int i = 0; i < persons.size(); i++) {
            Integer id = persons.get(i).getDepartment().getId();
            if (departmentPersonMap.get(id) == null) {
                departmentPersonMap.put(id, new LinkedList<>());
            }
            departmentPersonMap.get(id).add(persons.get(i));

            if (personMap.get(id) == null) {
                personMap.put(id, persons.get(i));
            }
        }
    }

    public List<Person> getPersonByDepartmentId(Integer id) {

        if (departmentPersonMap.containsKey(id)) {
            return departmentPersonMap.get(id);
        }
        return null;
    }

    public Person getPersonById(Integer id) {
        if(personMap.containsKey(id)){
            return personMap.get(id);
        }
        return null;
    }

    public Person addPerson(Person person) throws Exception {
        if(personMap.containsKey(person.getId())){
            throw new Exception("");
        }
        personMap.put(person.getId(), person);
        return person;
    }

    public static void main(String[] args) {
        PersonService personService = PersonService.getInstance();
    }
}

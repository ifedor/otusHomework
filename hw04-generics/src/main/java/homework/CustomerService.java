package homework;

import java.util.AbstractMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;

public class CustomerService {

    private final TreeMap<Customer, String> customers;

    public CustomerService() {
        customers = new TreeMap<>((o1, o2) -> (int) (o1.getScores() - o2.getScores()));
    }

    public Map.Entry<Customer, String> getSmallest() {
        var fe = customers.firstEntry();

        return new AbstractMap.SimpleEntry<>(
                new Customer(fe.getKey().getId(), fe.getKey().getName(), fe.getKey().getScores()),
                fe.getValue()
        );
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        if (customers.containsKey(customer)) {
            var tailIterator = customers.tailMap(customer).entrySet().iterator();
            try {
                tailIterator.next();
                return tailIterator.next();
            } catch (NoSuchElementException e) {
                return null;
            }
        } else {
            return customers.ceilingEntry(customer);
        }
    }

    public void add(Customer customer, String data) {
        customers.put(customer, data);
    }
}

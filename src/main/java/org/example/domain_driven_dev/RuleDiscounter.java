package org.example.domain_driven_dev;

import java.util.List;

public interface RuleDiscounter {
    Money applyRules(Customer customer, List<OrderLine> orderLines);
}

@Service
public class PriorityRuleService {

    private final PriorityRuleRepository repo;

    public PriorityRuleService(PriorityRuleRepository repo) {
        this.repo = repo;
    }

    public int calculatePriority(String category) {
        return repo.findByCategory(category)
                .map(PriorityRule::getBaseScore)
                .orElse(0);
    }

    public List<PriorityRule> getAllRules() {
        return repo.findAll();
    }
}
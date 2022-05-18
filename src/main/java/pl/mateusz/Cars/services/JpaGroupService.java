package pl.mateusz.Cars.services;

import org.springframework.stereotype.Service;
import pl.mateusz.Cars.entity.Group;
import pl.mateusz.Cars.repository.GroupRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JpaGroupService implements GroupService{
    private final GroupRepository groupRepository;

    public JpaGroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Optional<Group> findById(Long id) {
        return groupRepository.findById(id);
    }

    @Override
    public void save(Group group) {
        groupRepository.save(group);
    }

    @Override
    public void delete(Long id) {
        groupRepository.deleteById(id);
    }

    @Override
    public void update(Group group) {
        groupRepository.save(group);
    }
}

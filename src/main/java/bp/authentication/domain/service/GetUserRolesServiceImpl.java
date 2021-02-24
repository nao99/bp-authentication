package bp.authentication.domain.service;

import bp.authentication.domain.model.role.Role;
import bp.authentication.domain.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * GetUserRolesServiceImpl class
 *
 * @author  Nikolai Osipov <nao99.dev@gmail.com>
 * @version 1.0.0
 * @since   2021-02-24
 */
@Service
public class GetUserRolesServiceImpl implements GetUserRolesService {
    /**
     * Role repository
     */
    private final RoleRepository roleRepository;

    /**
     * GetUserRolesServiceImpl constructor
     *
     * @param roleRepository a role repository
     */
    @Autowired
    public GetUserRolesServiceImpl(final RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Role> getRolesBy(Long userId) {
        return roleRepository.findByUserId(userId);
    }
}

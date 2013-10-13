package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.UserRepository;
import service.api.UserService;
import service.converter.assembler.UserAssembler;
import service.converter.disassembler.UserDisassembler;
import service.dto.UserDto;

/**
 * @author Dmitry Tsydzik
 * @since Date: 13.10.13
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAssembler userAssembler;

    @Autowired
    private UserDisassembler userDisassembler;

    @Override
    public UserDto save(UserDto userDto) {
        return userDisassembler.convert(userRepository.save(userAssembler.convert(userDto)));
    }
}

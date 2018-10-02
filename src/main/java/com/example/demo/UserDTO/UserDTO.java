package com.example.demo.UserDTO;

import com.example.demo.domens.User;
import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
public class UserDTO {
    private  String email;
    private  String password;
    private  String password;

public static UserDTO from (User user){
    return UserDTO.
}
//    public static UserDTO from(User user) {
//        return UserDTO.
//        return UserDTO.builder()
//                .id(user.getId())
//
//                .build();
//    }


//    public static List<UserDTO> from(Iterable<User> usersIterable) {
//
//        List<User> users =  Lists.newArrayList(usersIterable);
//
//        return users.stream().map(UserDTO::from).collect(Collectors.toList());
//    }
}

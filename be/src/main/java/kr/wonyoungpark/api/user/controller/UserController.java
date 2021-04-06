package kr.wonyoungpark.api.user.controller;
import javax.servlet.http.HttpServletRequest;

import kr.wonyoungpark.api.user.domain.UserDto;
import kr.wonyoungpark.api.user.domain.UserResponseDto;
import kr.wonyoungpark.api.user.domain.UserVo;
import kr.wonyoungpark.api.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Api(tags = "users")
public class UserController {
    private final UserService service;
    private final ModelMapper modelMapper;
    @GetMapping("")
    public ResponseEntity<List<UserVo>> all(){
        System.out.println("all: ");
        return ResponseEntity.ok(service.all());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserVo>> one(@PathVariable long id){
        System.out.println("Item One Id: "+id);
        return ResponseEntity.ok(service.one(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> edit(@PathVariable long id, @RequestBody UserVo user){
        System.out.println("edit: "+user.toString());
        return ResponseEntity.ok(service.edit(user));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        return ResponseEntity.ok(service.delete(id));
    }

    @PostMapping("/signin")
    @ApiOperation(value = "${UserController.signin}")
    @ApiResponses(value = { //
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 422, message = "Invalid username/password supplied") })
    public ResponseEntity<Map<String, Object>> login(@RequestBody UserDto user) {
        // @ApiParam("username") @RequestParam String username
        System.out.println("username::: "+user.getUsername());
        System.out.println("password::: "+user.getPassword());
        return ResponseEntity.ok(service.signin(user.getUsername(), user.getPassword()));
    }

    @PostMapping("/signup")
    @ApiOperation(value = "${UserController.signup}")
    @ApiResponses(value = { //
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 422, message = "Username is already in use") })
    public String signup(@ApiParam("Signup User") @RequestBody UserDto user) {
        return service.signup(modelMapper.map(user, UserVo.class));
    }

    @DeleteMapping(value = "/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${UserController.delete}", authorizations = { @Authorization(value = "apiKey") })
    @ApiResponses(value = { //
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 404, message = "The user doesn't exist"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token") })
    public String delete(@ApiParam("Username") @PathVariable String username) {
        service.delete(username);
        return username;
    }

    @GetMapping(value = "/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${UserController.search}", response = UserResponseDto.class, authorizations = {
            @Authorization(value = "apiKey") })
    @ApiResponses(value = { //
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 404, message = "The user doesn't exist"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token") })
    public UserResponseDto search(@ApiParam("Username") @PathVariable String username) {
        return modelMapper.map(service.search(username), UserResponseDto.class);
    }

    @GetMapping(value = "/me")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    @ApiOperation(value = "${UserController.me}", response = UserResponseDto.class, authorizations = {
            @Authorization(value = "apiKey") })
    @ApiResponses(value = { //
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token") })
    public UserResponseDto whoami(HttpServletRequest req) {
        return modelMapper.map(service.whoami(req), UserResponseDto.class);
    }

    @GetMapping("/refresh")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public String refresh(HttpServletRequest req) {
        return service.refresh(req.getRemoteUser());
    }
}

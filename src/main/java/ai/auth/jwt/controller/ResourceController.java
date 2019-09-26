package ai.auth.jwt.controller;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ai.auth.jwt.domain.User;
import ai.auth.jwt.repository.UserRepository;

@RestController
public class ResourceController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TokenStore tokenStore;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping(value = "/auth-resource/getMessage")
	@PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
	public ResponseEntity<String> getMessage() {
		return new ResponseEntity<String>("Hello World!!", HttpStatus.OK);
	}

	@GetMapping(value = "/auth-resource/owner")
	@PreAuthorize("hasAuthority('ADMIN_USER')")
	public ResponseEntity<String> getOwnerName() {
		return new ResponseEntity<String>(
				SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString(), HttpStatus.OK);
	}

	@GetMapping(value = "/auth-resource/users")
	@PreAuthorize("hasAuthority('ADMIN_USER')")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping(value = "/encodeBase64")
	public String getBasicAuthToken(@RequestParam String clientId, @RequestParam String clientSecret) {
		byte[] encode = Base64.getEncoder().encode((clientId + ":" + clientSecret).getBytes());
		return "Basic " + new String(encode);
	}

	@GetMapping(value = "/encodeBCrypt")
	public String getEncodedPassword(@RequestParam String rawPassword) {
		return passwordEncoder.encode(rawPassword);
	}

	@PostMapping(value = "/oauth/token/revoke")
	@ResponseBody
	public ResponseEntity<String> revokeRefreshToken(@RequestParam String access_token,
			@RequestParam String grant_type) {
		if ("revoke".equalsIgnoreCase(grant_type) && tokenStore instanceof JdbcTokenStore) {
			((JdbcTokenStore) tokenStore).removeAccessToken(access_token);
			return new ResponseEntity<>("Access Token Revoked!!",HttpStatus.OK);
		}
		return new ResponseEntity<>("set revoke as grandType",HttpStatus.BAD_REQUEST);
	}
}

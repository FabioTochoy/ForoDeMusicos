package foromusicos.apirestreto.seguridad;

import foromusicos.apirestreto.dto.LoginDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthController {

    private final AuthenticationManager manager;
    private final TokenService tokenService;

    public AuthController(AuthenticationManager manager, TokenService tokenService) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginDTO dto) {
        try {
            Authentication auth = manager.authenticate(
                    new UsernamePasswordAuthenticationToken(dto.login(), dto.clave())
            );

            String token = tokenService.generarToken(dto.login());
            return ResponseEntity.ok(token);

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body("Usuario o contraseña incorrectos");//401
        }catch (Exception e) {
        return ResponseEntity.status(500).body("Error interno del servidor"); // 500
    }

    }
}

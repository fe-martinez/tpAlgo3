package tp;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javafx.scene.media.AudioClip;

public class Sonidos {
static HashMap<String,AudioClip> sonidos;
	
	static List<String> pathSonidos = List.of("../motherloadV2/src/rsc/Sonidos/Taladro.wav",
									"../motherloadV2/src/rsc/Sonidos/Helicoptero.wav",
									"../motherloadV2/src/rsc/Sonidos/Golpe2.wav",
									"../motherloadV2/src/rsc/Sonidos/Muerte2.wav",
									"../motherloadV2/src/rsc/Sonidos/Comprar.wav",
									"../motherloadV2/src/rsc/Sonidos/Vender.mp3",
									"../motherloadV2/src/rsc/Sonidos/Alerta2.wav",
									"../motherloadV2/src/rsc/Sonidos/Teleport2.wav",
									"../motherloadV2/src/rsc/Sonidos/Ready1.wav",
									"../motherloadV2/src/rsc/Sonidos/PowerUp1.wav",
									"../motherloadV2/src/rsc/Sonidos/Click.wav",
									"../motherloadV2/src/rsc/Sonidos/GameOver9.wav",
									"../motherloadV2/src/rsc/Sonidos/Menu.mp3",
									"../motherloadV2/src/rsc/Sonidos/Jugando.mp3",
									"../motherloadV2/src/rsc/Sonidos/LostGame.mp3",
									"../motherloadV2/src/rsc/Sonidos/WinGame.mp3",
									"../motherloadV2/src/rsc/Sonidos/Tiendas.mp3",
									"../motherloadV2/src/rsc/Sonidos/Error.mp3",
									"../motherloadV2/src/rsc/Sonidos/Landed.wav",
									"../motherloadV2/src/rsc/Sonidos/Credits.mp3",
									"../motherloadV2/src/rsc/Sonidos/musica-historia.mp3",
									"../motherloadV2/src/rsc/Sonidos/suspenso-2.mp3",
									"../motherloadV2/src/rsc/Sonidos/sad.mp3",
									"../motherloadV2/src/rsc/Sonidos/audio-explosion.mp3");
	
	static List<String> keySonidos = List.of("Taladro",
									"Helicoptero",
									"Golpe",
									"Muerte",
									"Comprar",
									"Vender",
									"Alerta",
									"Teleport",
									"Get ready",
									"PowerUp",
									"Elegir opcion",
									"Game over",
									"Menu",
									"Jugando",
									"Lost Game",
									"Win Game",
									"Tiendas",
									"Error",
									"Landed",
									"Credits",
									"Inicio",
									"Suspenso",
									"Sad",
									"Explosion");
	public Sonidos() {
		cargarSonidos();
	}
	
	public static void cargarSonidos() {
		sonidos = new HashMap<>();
		for(int i = 0; i < pathSonidos.size(); i++) {
			sonidos.put(keySonidos.get(i),new AudioClip(new File(pathSonidos.get(i)).toURI().toString()));
		}
	}
	
	public static void setVolumenGeneral(double volumen) {
		sonidos.forEach((key, value) -> value.setVolume(volumen));
		sonidos.get("Jugando").setVolume(0.1);
	}

	
	public static void reproducir(String sonido) {
		if(sonidos.containsKey(sonido) && !sonidos.get(sonido).isPlaying()) {
			sonidos.get(sonido).play();
		}
	}
	
	public static void stopReproduccion(String sonido) {
		if(sonidos.containsKey(sonido) && sonidos.get(sonido).isPlaying()) {
			sonidos.get(sonido).stop();
		}
	}
	
	public static void setVolumen(String sonido,double valor) {
		if(sonidos.containsKey(sonido) && sonidos.get(sonido).isPlaying()) {
			sonidos.get(sonido).setVolume(valor);
		}
	}
	
	public static boolean existe(String sonido) {
		return sonidos.containsKey(sonido);
	}
	
	public static boolean isPlaying(String sonido) {
		if(sonidos.containsKey(sonido)) {
			return sonidos.get(sonido).isPlaying();
			
		}
		return false;
	}


}

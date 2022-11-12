package it.begear.corso.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.begear.corso.service.ArciereService;
import it.begear.corso.service.GuerrieroService;
import it.begear.corso.service.MagoService;
import it.begear.corso.service.MostroService;
import it.begear.corso.service.UtenteService;

import it.begear.corso.model.*;

@Controller
public class UtenteController {

	@Autowired
	UtenteService UtenteService;

	@Autowired
	ArciereService arciereservice;

	@Autowired
	GuerrieroService guerrieroservice;

	@Autowired 
	MagoService magoservice;

	@Autowired 
	MostroService mostroservice;


	//ControlUser � il controllo utente che si fa nella schermata di login.
	//vi � inclusa una logica di validazione che si accerta se ci sono credenziali vuote o già esistenti.
	@RequestMapping(value = "/controlUser", method = RequestMethod.POST)
	public String controlUser(@ModelAttribute("utente") Utente user, Model model) {
		List<Utente> users = UtenteService.SelectUser(user);
		if(users.size()==0) {
			model.addAttribute("message3", "Credenziali non valide! Riprova o registrati.");
			return "redirect:/login";
		} else if ((arciereservice.getUser(user).size()==0) && (guerrieroservice.getUser(user).size()==0) && (magoservice.getUser(user).size()==0)) {
			model.addAttribute("eroe", new Eroe(user.getUtente()));
			return "creazionepersonaggio";
		} else {
			List<Arciere> arciere = arciereservice.getArciere(user.getUtente());
			List<Guerriero> guerriero = guerrieroservice.getGuerriero(user.getUtente());
			List<Mago> mago = magoservice.getMago(user.getUtente());
			if (arciere.size()!=0) {
				Arciere arciere1 = arciere.get(0);
				model.addAttribute("listeroe", arciere1);
				model.addAttribute("url", "images/ashe.gif");
			} else if(guerriero.size()!=0) {
				Guerriero guerriero1 = guerriero.get(0);
				model.addAttribute("listeroe", guerriero1);
				model.addAttribute("url", "images/garen.gif");
			} else if (mago.size()!=0) {
				Mago mago1 = mago.get(0);
				model.addAttribute("listeroe", mago1);
				model.addAttribute("url", "images/lux.gif");
			}
			return "homepagegame";
		}
	}

	//mapping dei messaggi di errore nelle relative pagine. Per aggiungere nuovi messaggi nella stessa view
	//aggiungere un @ModelAttribute in pi� tra i valori in ingresso.
	@RequestMapping(value = "/registrati")
	public String registrazione(Model model, @ModelAttribute("message") String string) {
		model.addAttribute("utente", new Utente());
		return "addUser";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, @ModelAttribute("message3") String string1, @ModelAttribute("message2") String string) {
		model.addAttribute("utente", new Utente());
		return "login";
	}


	//aggiunge l'utente. Se i valori di entrambi i campi sono null, rimanda alla registrazione,
	//E restituisce un messaggio di errore sia nel caso di duplicato, sia nel caso in cui non si inserisce nulla.
	//(Ora ci sta un controllo di validazione che impedisce di inserire valori vuoti nel database).
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("utente")Utente user, Model model){
		List<Utente> users = UtenteService.SelectUser(user);
		if(users.size()!=0) {
			model.addAttribute("message2", "Utente gia' registrato! Accedi");
			return "redirect:/login";
		} else if (user.getUtente().isEmpty() || user.getPassword().isEmpty()) {
			model.addAttribute("message", "Dati non validi!");
			return "redirect:/registrati";
		} else {
			model.addAttribute("message2", "Utente registrato correttamente! Accedi");
			UtenteService.addUser(user);
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/addPg", method = RequestMethod.POST)
	public String addPG(@ModelAttribute("eroe") Eroe eroe, Model model) {
		if(eroe.getClasse().equals("0") || eroe.getNome().isEmpty()) {
			model.addAttribute("error", "Dati Sbagliati!");
			return "creazionepersonaggio";
		} else if(eroe.getClasse().equalsIgnoreCase("arciere")) {
			model.addAttribute("arciere", new Arciere(eroe.getUtente(), eroe.getNome()));
			return "equipArciere";
		} else if (eroe.getClasse().equalsIgnoreCase("guerriero")) {
			model.addAttribute("guerriero", new Guerriero(eroe.getUtente(), eroe.getNome()));
			return "equipGuerriero";
		} else {
			model.addAttribute("mago", new Mago(eroe.getUtente(), eroe.getNome()));
			return "equipMago";
		}
	}

	@RequestMapping(value = "/addEquipArciere", method = RequestMethod.POST)
	private String addEquipArciere(@ModelAttribute("arciere")Arciere arciere, Model model) {
		if(arciere.getId_arma()==3) {
			arciere.setDestrezza(25);
			arciere.setForza(15);
			arciere.setSaggezza(10);
			arciere.setLivello(1);
			arciere.setHp(250);
			if(arciere.getId_armatura()==3) {
				arciere.setDifesa(13);
				arciereservice.addArciere(arciere);
			} else if (arciere.getId_armatura()==4) {
				arciere.setHp(300);
				arciere.setDifesa(9);
				arciereservice.addArciere(arciere);
			} else {
				model.addAttribute("errorequip", "Arma o armatura non valide");
				return "equipArciere";
			}
		} else if (arciere.getId_arma()==4) {
			arciere.setDestrezza(22);
			arciere.setLivello(2);
			arciere.setHp(260);
			arciere.setForza(17);
			arciere.setSaggezza(12);
			if(arciere.getId_armatura()==3) {
				arciere.setDifesa(15);
				arciereservice.addArciere(arciere);
			} else if (arciere.getId_armatura()==4) {
				arciere.setDifesa(11);
				arciere.setHp(310);
				arciereservice.addArciere(arciere);
			}else {
				model.addAttribute("errorequip", "Arma o armatura non valide");
				return "equipArciere";
			}
		} else {
			model.addAttribute("errorequip", "Arma o armatura non valide");
			return "equipArciere";
		}
		List<Arciere> arcieri = arciereservice.getArciere(arciere.getUtente());
		Arciere arciere1 = arcieri.get(0);
		model.addAttribute("listeroe", arciere1);
		model.addAttribute("url", "images/ashe.gif");
		return "homepagegame";
	}

	@RequestMapping(value = "/addEquipGuerriero", method = RequestMethod.POST)
	private String addEquipGuerriero(@ModelAttribute("guerriero")Guerriero guerriero, Model model) {
		if(guerriero.getId_arma()==1) {
			guerriero.setDestrezza(15);
			guerriero.setForza(25);
			guerriero.setSaggezza(10);
			guerriero.setLivello(1);
			guerriero.setHp(250);
			if(guerriero.getId_armatura()==1) {
				guerriero.setDifesa(13);
				guerrieroservice.addGuerriero(guerriero);
			} else if (guerriero.getId_armatura()==2) {
				guerriero.setHp(300);
				guerriero.setDifesa(9);
				guerrieroservice.addGuerriero(guerriero);
			}else {
				model.addAttribute("erroequip", "Arma o armatura non valide");
				return "equipGuerriero";
			}
		} else if (guerriero.getId_arma()==2) {
			guerriero.setDestrezza(17);
			guerriero.setLivello(2);
			guerriero.setHp(260);
			guerriero.setForza(22);
			guerriero.setSaggezza(12);
			if(guerriero.getId_armatura()==1) {
				guerriero.setDifesa(15);
				guerrieroservice.addGuerriero(guerriero);
			} else if (guerriero.getId_armatura()==2) {
				guerriero.setHp(310);
				guerriero.setDifesa(11);
				guerrieroservice.addGuerriero(guerriero);
			}else {
				model.addAttribute("errorequip", "Arma o armatura non valide");
				return "equipGuerriero";
			}	
		} else {
			model.addAttribute("erroequip", "Arma o armatura non valide");
			return "equipGuerriero";
		}
		List<Guerriero> guerrieri = guerrieroservice.getGuerriero(guerriero.getUtente());
		Guerriero guerriero1 = guerrieri.get(0);
		model.addAttribute("listeroe", guerriero1);
		model.addAttribute("url", "images/garen.gif");
		return "homepagegame";
	}

	@RequestMapping(value = "/addEquipMago", method = RequestMethod.POST)
	private String addEquipMago(@ModelAttribute("mago")Mago mago, Model model) {
		if(mago.getId_arma()==5) {
			mago.setDestrezza(15);
			mago.setForza(10);
			mago.setSaggezza(25);
			mago.setLivello(1);
			mago.setHp(250);
			if(mago.getId_armatura()==5) {
				mago.setDifesa(13);
				magoservice.addMago(mago);
			} else if (mago.getId_armatura()==6) {
				mago.setHp(300);
				mago.setDifesa(9);
				magoservice.addMago(mago);
			}else {
				model.addAttribute("errorequip", "Arma o armatura non valide");
				return "equipMago";
			}
		} else if (mago.getId_arma()==6) {
			mago.setDestrezza(17);
			mago.setLivello(2);
			mago.setHp(260);
			mago.setForza(12);
			mago.setSaggezza(22);
			if(mago.getId_armatura()==5) {
				mago.setDifesa(15);
				magoservice.addMago(mago);
			} else if (mago.getId_armatura()==6) {
				mago.setHp(310);
				mago.setDifesa(11);
				magoservice.addMago(mago);
			} else {
				model.addAttribute("errorequip", "Arma o armatura non valide");
				return "equipMago";
			}
		} else {
			model.addAttribute("erroequip", "Arma o armatura non valide");
			return "equipMago";
		}
		List<Mago> maghi = magoservice.getMago(mago.getUtente());
		Mago mago1 = maghi.get(0);
		model.addAttribute("listeroe", mago1);
		model.addAttribute("url", "images/lux.gif");
		return "homepagegame";
	}

	@RequestMapping(value = "/esplora", method = RequestMethod.POST)
	public String esplora(@ModelAttribute("listeroe")Eroe eroe) {
		return "mappa";
	}


	@RequestMapping(value = "/vaiarea1", method = RequestMethod.POST)
	public String vaiarea1(@ModelAttribute("listeroe")Eroe eroe, Model model ) {
		model.addAttribute("message2", "si");
		return "area1";
	}

	@RequestMapping(value = "/vaiarea2", method = RequestMethod.POST)
	public String vaiarea2(@ModelAttribute("listeroe")Eroe eroe, Model model ) {
		model.addAttribute("message2", "si");
		return "area2";
	}

	@RequestMapping(value = "/vaiarea3", method = RequestMethod.POST)
	public String vaiarea3(@ModelAttribute("listeroe")Eroe eroe, Model model ) {
		model.addAttribute("message2", "si");
		return "area3";
	}
	@RequestMapping(value = "/vaihomepage", method = RequestMethod.POST)
	public String vaihomepage(@ModelAttribute("listeroe")Eroe eroe, Model model ) {
		if(eroe.getForza()>20) {
			model.addAttribute("url", "images/garen.gif");
		} else if (eroe.getDestrezza()>20) {
			model.addAttribute("url", "images/ashe.gif");
		} else if(eroe.getSaggezza()>20) {
			model.addAttribute("url", "images/lux.gif");
		}
		return "homepagegame";
	}

	@RequestMapping(value = "/combattiarea1",  method = RequestMethod.POST)
	public String combatArea1(@ModelAttribute("listeroe")Eroe eroe, Model model) {

		List<Mostro> arpie = mostroservice.getMostroA1();
		Mostro arpia = arpie.get(0);
		model.addAttribute("mostro", arpia);
		model.addAttribute("urlm", "images/arpia_avatar.gif");
		if(eroe.getForza()>20) {
			model.addAttribute("url", "images/garen.gif");
		} else if (eroe.getDestrezza()>20) {
			model.addAttribute("url", "images/ashe.gif");
		} else if(eroe.getSaggezza()>20) {
			model.addAttribute("url", "images/lux.gif");
		}
		return "combatarea";
	}

	@RequestMapping(value = "/combattiarea2",  method = RequestMethod.POST)
	public String combatArea2(@ModelAttribute("listeroe")Eroe eroe, Model model) {
		List<Mostro> golems = mostroservice.getMostroA2();
		Mostro golem = golems.get(0);
		model.addAttribute("mostro", golem);
		model.addAttribute("urlm", "images/golem_avatar.gif");
		if(eroe.getForza()>20) {
			model.addAttribute("url", "images/garen.gif");
		} else if (eroe.getDestrezza()>20) {
			model.addAttribute("url", "images/ashe.gif");
		} else if(eroe.getSaggezza()>20) {
			model.addAttribute("url", "images/lux.gif");
		}
		return "combatarea";
	}

	@RequestMapping(value = "/combattiarea3",  method = RequestMethod.POST)
	public String combatArea3(@ModelAttribute("listeroe")Eroe eroe, Model model) {
		List<Mostro> spiriti = mostroservice.getMostroA3();
		Mostro spirito = spiriti.get(0);
		model.addAttribute("mostro", spirito);
		model.addAttribute("urlm", "images/spirito_avatar.gif");
		if(eroe.getForza()>20) {
			model.addAttribute("url", "images/garen.gif");
		} else if (eroe.getDestrezza()>20) {
			model.addAttribute("url", "images/ashe.gif");
		} else if(eroe.getSaggezza()>20) {
			model.addAttribute("url", "images/lux.gif");
		}
		return "combatarea";
	}

	@RequestMapping(value ="/attaccobase",  method = RequestMethod.POST)
	public String attaccoBase(@ModelAttribute("listeroe")Eroe eroe, @ModelAttribute("mostro")Mostro mostro, Model model) {
		if(mostro.getArea().equalsIgnoreCase("area1")) {
			int danno = (int) ((eroe.getForza()*0.8*Math.random()+eroe.getDestrezza()*1.5+eroe.getSaggezza()*0.6*Math.random())-mostro.getDifesamostro());
			mostro.setVita(mostro.getVita() - danno);
			model.addAttribute("mostro", mostro);
			int dannomostro= (int) ((mostro.getAttacco()-eroe.getDifesa())*Math.random()+10);
			eroe.setHp(eroe.getHp()- dannomostro);
			model.addAttribute("eroe", eroe);
			model.addAttribute("colpobase", "si");
			model.addAttribute("danno", danno);
			model.addAttribute("dannomostro", dannomostro);
			model.addAttribute("attmost", "images/attacarpia.gif");
			if(eroe.getForza()>20) {
				model.addAttribute("attpg", "images/garenattack.gif");
			} else if (eroe.getDestrezza()>20) {
				model.addAttribute("attpg", "images/asheattack.gif");
			} else if(eroe.getSaggezza()>20) {
				model.addAttribute("attpg", "images/luxattack.gif");
			} 
			if(mostro.getVita()<=0) {
				model.addAttribute("winner", "Hai vinto!");
				if(eroe.getForza()>20) {
					model.addAttribute("teleport", "images/garenteleport.gif");
				} else if (eroe.getDestrezza()>20) {
					model.addAttribute("teleport", "images/asheteleport.gif");
				} else if(eroe.getSaggezza()>20) {
					model.addAttribute("teleport", "images/luxteleport.gif");
				} 
				return "area1";
			}else if(eroe.getHp()<=0) {
				model.addAttribute("loser", "Hai perso!");
				if(eroe.getForza()>20) {
					model.addAttribute("url", "images/garenmorte.gif");
					model.addAttribute("teleport", "images/garenteleport.gif");
				} else if (eroe.getDestrezza()>20) {
					model.addAttribute("teleport", "images/asheteleport.gif");
					model.addAttribute("url", "images/ashemorte.gif");
				} else if(eroe.getSaggezza()>20) {
					model.addAttribute("url", "images/luxmorte.gif");
					model.addAttribute("teleport", "images/luxteleport.gif");
				} 
				return "area1";
			}
			else  {
				return "combatarea";
			}
		} else if (mostro.getArea().equalsIgnoreCase("area2")) {
			int danno = (int) ((eroe.getForza()*1.5+eroe.getDestrezza()*0.8*Math.random()+eroe.getSaggezza()*0.6*Math.random())-mostro.getDifesamostro());
			mostro.setVita(mostro.getVita() - danno);
			model.addAttribute("mostro", mostro);
			int dannomostro= (int) ((mostro.getAttacco()-eroe.getDifesa())*Math.random()+5);
			eroe.setHp(eroe.getHp()- dannomostro);
			model.addAttribute("eroe", eroe);
			model.addAttribute("colpobase", "si");
			model.addAttribute("danno", danno);
			model.addAttribute("dannomostro", dannomostro);
			model.addAttribute("attmost", "images/attacgolem.gif");
			if(eroe.getForza()>20) {
				model.addAttribute("attpg", "images/garenattack.gif");
			} else if (eroe.getDestrezza()>20) {
				model.addAttribute("attpg", "images/asheattack.gif");
			} else if(eroe.getSaggezza()>20) {
				model.addAttribute("attpg", "images/luxattack.gif");
			} 
			if(mostro.getVita()<0) {
				model.addAttribute("winner", "Hai vinto!");
				if(eroe.getForza()>20) {
					model.addAttribute("teleport", "images/garenteleport.gif");
				} else if (eroe.getDestrezza()>20) {
					model.addAttribute("teleport", "images/asheteleport.gif");
				} else if(eroe.getSaggezza()>20) {
					model.addAttribute("teleport", "images/luxteleport.gif");
				} 
				return "area2";
			}else if(eroe.getHp()<0) {
				model.addAttribute("loser", "Hai perso!");
				if(eroe.getForza()>20) {
					model.addAttribute("url", "images/garenmorte.gif");
					model.addAttribute("teleport", "images/garenteleport.gif");
				} else if (eroe.getDestrezza()>20) {
					model.addAttribute("teleport", "images/asheteleport.gif");
					model.addAttribute("url", "images/ashemorte.gif");
				} else if(eroe.getSaggezza()>20) {
					model.addAttribute("url", "images/luxmorte.gif");
					model.addAttribute("teleport", "images/luxteleport.gif");
				} 
				return "area2";
			} else {
				return "combatarea";
			}
		} else {
			int danno= (int) ((eroe.getForza()*0.6*Math.random()+eroe.getDestrezza()*0.8*Math.random()+eroe.getSaggezza()*1.5)-mostro.getDifesamostro());
			mostro.setVita(mostro.getVita() - danno);
			model.addAttribute("mostro", mostro);
			int dannomostro= (int) ((mostro.getAttacco()-eroe.getDifesa())*Math.random()+5);
			eroe.setHp(eroe.getHp()- dannomostro);
			model.addAttribute("eroe", eroe);
			model.addAttribute("colpobase", "si");
			model.addAttribute("danno", danno);
			model.addAttribute("dannomostro", dannomostro);
			model.addAttribute("attmost", "images/attacspirito.gif");
			if(eroe.getForza()>20) {
				model.addAttribute("attpg", "images/garenattack.gif");
			} else if (eroe.getDestrezza()>20) {
				model.addAttribute("attpg", "images/asheattack.gif");
			} else if(eroe.getSaggezza()>20) {
				model.addAttribute("attpg", "images/luxattack.gif");
			} 
			if(mostro.getVita()<0) {
				model.addAttribute("winner", "Hai vinto!");
				if(eroe.getForza()>20) {
					model.addAttribute("teleport", "images/garenteleport.gif");
				} else if (eroe.getDestrezza()>20) {
					model.addAttribute("teleport", "images/asheteleport.gif");
				} else if(eroe.getSaggezza()>20) {
					model.addAttribute("teleport", "images/luxteleport.gif");
				} 
				return "area3";
			}else if(eroe.getHp()<0) {
				model.addAttribute("loser", "Hai perso!");
				if(eroe.getForza()>20) {
					model.addAttribute("url", "images/garenmorte.gif");
					model.addAttribute("teleport", "images/garenteleport.gif");
				} else if (eroe.getDestrezza()>20) {
					model.addAttribute("teleport", "images/asheteleport.gif");
					model.addAttribute("url", "images/ashemorte.gif");
				} else if(eroe.getSaggezza()>20) {
					model.addAttribute("url", "images/luxmorte.gif");
					model.addAttribute("teleport", "images/luxteleport.gif");
				} 
				return "area3";
			} else {
				return "combatarea";
			}
		}
	}

	@RequestMapping(value ="/attaccospeciale",  method = RequestMethod.POST)
	public String attaccoSpeciale(@ModelAttribute("listeroe")Eroe eroe, @ModelAttribute("mostro")Mostro mostro, Model model) {
		if(mostro.getArea().equalsIgnoreCase("area1")) {
			if(eroe.getDestrezza()>20) {
				model.addAttribute("specialpg", "images/ashespecial.gif");
				model.addAttribute("skill", eroe.AbilitaSpeciale("arciere"));
				model.addAttribute("danno", "Infligge 60 danni!");
				mostro.setVita(mostro.getVita() - 60);
				if(mostro.getVita()<=0) {
					model.addAttribute("winner", "Hai vinto!");
					if(eroe.getForza()>20) {
						model.addAttribute("teleport", "images/garenteleport.gif");
					} else if (eroe.getDestrezza()>20) {
						model.addAttribute("teleport", "images/asheteleport.gif");
					} else if(eroe.getSaggezza()>20) {
						model.addAttribute("teleport", "images/luxteleport.gif");
					} 
					return "area1";
				}
				model.addAttribute("mostro", mostro);
			} else if (eroe.getForza()>20) {
				model.addAttribute("specialpg", "images/garenspecial.gif");
				model.addAttribute("skill", eroe.AbilitaSpeciale("guerriero"));
				model.addAttribute("message", "Abilità speciale inefficace!");
			} else if (eroe.getSaggezza()>20) {
				model.addAttribute("specialpg", "images/luxspecial.gif");
				model.addAttribute("skill", eroe.AbilitaSpeciale("mago"));
				model.addAttribute("message", "Abilità speciale inefficace!");
			}
			int dannomostro= (int) ((mostro.getAttacco()-eroe.getDifesa())*Math.random()+5);
			eroe.setHp(eroe.getHp()- dannomostro);
			model.addAttribute("dannomostro", dannomostro);
			if(eroe.getHp()<=0) {
				model.addAttribute("loser", "Hai perso!");
				if(eroe.getForza()>20) {
					model.addAttribute("url", "images/garenmorte.gif");
					model.addAttribute("teleport", "images/garenteleport.gif");
				} else if (eroe.getDestrezza()>20) {
					model.addAttribute("teleport", "images/asheteleport.gif");
					model.addAttribute("url", "images/ashemorte.gif");
				} else if(eroe.getSaggezza()>20) {
					model.addAttribute("url", "images/luxmorte.gif");
					model.addAttribute("teleport", "images/luxteleport.gif");
				} 
				return "area1";
			}
			model.addAttribute("eroe", eroe);
			model.addAttribute("attmost", "images/attacarpia.gif");
			model.addAttribute("colpospecial", "si");
			return "combatarea";
		} else if(mostro.getArea().equalsIgnoreCase("area2")) {
			if(eroe.getForza()>20) {
				model.addAttribute("specialpg", "images/garenspecial.gif");
				model.addAttribute("skill", eroe.AbilitaSpeciale("guerriero"));
				model.addAttribute("danno", "Infligge 60 danni!");
				mostro.setVita(mostro.getVita() - 60);
				if(mostro.getVita()<=0) {
					model.addAttribute("winner", "Hai vinto!");
					if(eroe.getForza()>20) {
						model.addAttribute("teleport", "images/garenteleport.gif");
					} else if (eroe.getDestrezza()>20) {
						model.addAttribute("teleport", "images/asheteleport.gif");
					} else if(eroe.getSaggezza()>20) {
						model.addAttribute("teleport", "images/luxteleport.gif");
					} 
					return "area2";
				}
				model.addAttribute("mostro", mostro);
			} else if(eroe.getDestrezza()>20) {
				model.addAttribute("specialpg", "images/ashespecial.gif");
				model.addAttribute("skill", eroe.AbilitaSpeciale("arciere"));
				model.addAttribute("message", "Abilità speciale inefficace!");
			} else if (eroe.getSaggezza()>20) {
				model.addAttribute("message", "Abilità speciale inefficace!");
				model.addAttribute("specialpg", "images/luxspecial.gif");
				model.addAttribute("skill", eroe.AbilitaSpeciale("mago"));
			}
			int dannomostro= (int) ((mostro.getAttacco()-eroe.getDifesa())*Math.random()+5);
			eroe.setHp(eroe.getHp()- dannomostro);
			model.addAttribute("dannomostro", dannomostro);
			if(eroe.getHp()<=0) {
				model.addAttribute("loser", "Hai perso!");
				if(eroe.getForza()>20) {
					model.addAttribute("url", "images/garenmorte.gif");
					model.addAttribute("teleport", "images/garenteleport.gif");
				} else if (eroe.getDestrezza()>20) {
					model.addAttribute("teleport", "images/asheteleport.gif");
					model.addAttribute("url", "images/ashemorte.gif");
				} else if(eroe.getSaggezza()>20) {
					model.addAttribute("url", "images/luxmorte.gif");
					model.addAttribute("teleport", "images/luxteleport.gif");
				} 
				return "area2";
			}
			model.addAttribute("eroe", eroe);
			model.addAttribute("attmost", "images/attacgolem.gif");
			model.addAttribute("colpospecial", "si");
			return "combatarea";
		} else {
			if(eroe.getSaggezza()>20) {
				model.addAttribute("specialpg", "images/luxspecial.gif");
				model.addAttribute("skill", eroe.AbilitaSpeciale("mago"));
				model.addAttribute("danno", "Infligge 60 danni!");
				mostro.setVita(mostro.getVita() - 60);
				if(mostro.getVita()<=0) {
					model.addAttribute("winner", "Hai vinto!");
					if(eroe.getForza()>20) {
						model.addAttribute("teleport", "images/garenteleport.gif");
					} else if (eroe.getDestrezza()>20) {
						model.addAttribute("teleport", "images/asheteleport.gif");
					} else if(eroe.getSaggezza()>20) {
						model.addAttribute("teleport", "images/luxteleport.gif");
					} 
					return "area3";
				}
				model.addAttribute("mostro", mostro);
			} else if(eroe.getForza()>20) {
				model.addAttribute("specialpg", "images/garenspecial.gif");
				model.addAttribute("skill", eroe.AbilitaSpeciale("guerriero"));
				model.addAttribute("message", "Abilità speciale inefficace!");
			} else if (eroe.getDestrezza()>20) {
				model.addAttribute("specialpg", "images/ashespecial.gif");
				model.addAttribute("skill", eroe.AbilitaSpeciale("arciere"));
				model.addAttribute("message", "Abilità speciale inefficace!");
			}
			int dannomostro= (int) ((mostro.getAttacco()-eroe.getDifesa())*Math.random()+5);
			eroe.setHp(eroe.getHp()- dannomostro);
			model.addAttribute("dannomostro", dannomostro);
			if(eroe.getHp()<=0) {
				model.addAttribute("loser", "Hai perso!");
				if(eroe.getForza()>20) {
					model.addAttribute("url", "images/garenmorte.gif");
					model.addAttribute("teleport", "images/garenteleport.gif");
				} else if (eroe.getDestrezza()>20) {
					model.addAttribute("teleport", "images/asheteleport.gif");
					model.addAttribute("url", "images/ashemorte.gif");
				} else if(eroe.getSaggezza()>20) {
					model.addAttribute("url", "images/luxmorte.gif");
					model.addAttribute("teleport", "images/luxteleport.gif");
				} 
				return "area3";			
			}
			model.addAttribute("eroe", eroe);
			model.addAttribute("attmost", "images/attacspirito.gif");
			model.addAttribute("colpospecial", "si");
			return "combatarea";
		} 
	}

	@RequestMapping(value="/vaivillaggio")
	public String vaiVillaggio(@ModelAttribute("listeroe")Eroe eroe, Model model) {
		List<Arciere> arciere = arciereservice.getArciere(eroe.getUtente());
		List<Guerriero> guerriero = guerrieroservice.getGuerriero(eroe.getUtente());
		List<Mago> mago = magoservice.getMago(eroe.getUtente());
		if (arciere.size()!=0) {
			Arciere arciere1 = arciere.get(0);
			model.addAttribute("listeroe", arciere1);
			model.addAttribute("url", "images/ashe.gif");
		} else if(guerriero.size()!=0) {
			Guerriero guerriero1 = guerriero.get(0);
			model.addAttribute("listeroe", guerriero1);
			model.addAttribute("url", "images/garen.gif");
		} else if (mago.size()!=0) {
			Mago mago1 = mago.get(0);
			model.addAttribute("listeroe", mago1);
			model.addAttribute("url", "images/lux.gif");
		}
		return "homepagegame";
	}
}
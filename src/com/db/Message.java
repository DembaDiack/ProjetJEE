package com.db;

public class Message {
	public static String msg(int r,String token) {
		String role = "";
		if(r == 1) {
			role  = "administrateur";
		}
		if(r == 2) {
			role = "directeur";
		}
		if(r == 3) {
			role = "enseignant";
		}
		String text = "<html>\r\n" + 
				"\r\n" + 
				"<body>\r\n" + 
				"    \r\n" + 
				"    <h3>\r\n" + 
				"        bienvenue cher uttilisateur vous etes connecte en tant que :" + role +
				"        votre cle est : <span style='color:red'>" +token + "</span>" +
				"        les menus son : </h3> :\r\n" + 
				"        <ul>\r\n" + 
				"            <li>enseignant</li>\r\n" + 
				"            <li>directeurs</li>\r\n" + 
				"            <li>matieres</li>\r\n" + 
				"            <li>crenaux</li>\r\n" + 
				"        </ul>\r\n" +
				"    <br>\r\n" + 
				"    <h4>\r\n" + 
				"        ----enseignants----\r\n" + 
				"    </h4>\r\n" + 
				"    <ul>\r\n" + 
				"        <li>ajouter enseignants : \r\n" + 
				"            cle_daccess/enseignant/ajouter?\r\n" + 
				"            nom=nom_enseignant&\r\n" + 
				"            prenom&\r\n" + 
				"            prenom_enseignant\r\n" + 
				"            &id=id_enseignant\r\n" + 
				"            &username=nom_duttilisateur\r\n" + 
				"            &password=mot_de_passe_enseignant\r\n" + 
				"        </li>\r\n" + 
				"        <li>\r\n" + 
				"            voir tout les enseignants : enseignant/all\r\n" + 
				"        </li>\r\n" + 
				"    </ul>\r\n" + 
				"    <h4>\r\n" + 
				"        ----directeur----\r\n" + 
				"    </h4>\r\n" + 
				"    <ul>\r\n" + 
				"        <li>\r\n" + 
				"            ajouter enseignants : \r\n" + 
				"            cle_daccess/directeur/ajouter?\r\n" + 
				"            nom=nom_directeur&\r\n" + 
				"            prenom&\r\n" + 
				"            prenom_directeur\r\n" + 
				"            &id=id_directeur\r\n" + 
				"            &username=nom_duttilisateur\r\n" + 
				"            &password=mot_de_passe_directeur\r\n" + 
				"        </li>\r\n" + 
				"        <li>\r\n" + 
				"            voir tout les directeur :directeur/all\r\n" + 
				"        </li>\r\n" + 
				"    </ul>\r\n" + 
				"    <h4>\r\n" + 
				"        ----crenaux----\r\n" + 
				"    </h4>\r\n" + 
				"    <li>\r\n" + 
				"        ajouter crenaux : cle_daccess/crenaux/ajouter?\r\n" + 
				"        id=id_crenaux\r\n" + 
				"        &h=heure_crenau\r\n" + 
				"        &m=minute_crenau\r\n" + 
				"    </li>\r\n" + 
				"    <li>\r\n" + 
				"        voir tout les crenaux : crenaux/all\r\n" + 
				"    </li>\r\n" + 
				"    <h4>\r\n" + 
				"        ----matiere----\r\n" + 
				"    </h4>\r\n" + 
				"    <li>\r\n" + 
				"        ajouter matiere : cle_daccess/matiere/ajouter?\r\n" + 
				"        id=id_matiere\r\n" + 
				"        &code=code_matiere\r\n" + 
				"        &nom=nom_matiere\r\n" + 
				"        &idcrenau=id_du_crenau_horaire_de_la_matiere\r\n" + 
				"    </li>\r\n" + 
				"    <li>\r\n" + 
				"        voir tout les matiere : matiere/all\r\n" + 
				"    </li>\r\n" + 
				"</body>\r\n" + 
				"</html>";
		return text;
	}
}


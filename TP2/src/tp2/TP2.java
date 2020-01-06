/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Marc Antoine Abou Jaoude 1742177
 */
public class TP2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// tableaux qui contiendra les valeurs
        Boolean[] tabBoolean = new Boolean[24];
        int[] tabsixNumero = new int[6];
        boolean[] tabValidation = new boolean[24];
        int[] tabQuatreNumero = new int[4];
        int[] tabTroisNumero = new int[3];
        int[] tabDeuxNumero = new int[2];
        //Initialisation des tableaux à utiliser 
        final int montIni = 100, bornePasse = 19, borneManque = 18;
        int choix, temp, compteur2, montant, mise, gain, chiffreSeul = 0,
                compteur1 = 0, taille = tabBoolean.length, nombreAleatoire;
        String nom;
        Boolean trueFalse, egalite = false;
        Random r = new Random();
        Scanner clavier = new Scanner(System.in);
        // Initialisation de l'ensemble des valeurs nécessaires
        for (compteur1 = 0; compteur1 < taille; compteur1++) {
//pour remplir les tableaux
            if (compteur1 == 0) {
//on s'assure de ne pas donner une valeur au zéro
                tabBoolean[compteur1] = null;
            } else if (compteur1 % 2 == 0) {
// on identifie ainsi les nombres impairs et pairs
                tabBoolean[compteur1] = true;
            } else {
                tabBoolean[compteur1] = false;
            }

        }
        System.out.println("Bonjour! Bienvenue à la machine du passé!");
        System.out.println("Entrez votre nom!");

        nom = clavier.nextLine();
        System.out.println("Quel beau nom!");
        do {
            System.out.println("Donc cher(e) " + nom + " "
                    + "est ce que c'est votre première fois?");
            System.out.println("1.Oui 2.Non \n Entrez 1 ou 2");

            choix = clavier.nextInt();
        } while (choix < 0 || choix > 2);
        if (choix == 1) {
            System.out.println("Quel joie de vous avoir ! ");
            System.out.println("Le fonctionnement du jeu est très simple");
            System.out.println("C'est un jeu de hasard ou "
                    + "vous pourrez faire de l'argent!");
            do {
                System.out.println("D'abord veuillez entrer "
                        + "un montant initial de 100$");
                montant = clavier.nextInt();
            } while (montant != 100);
        } else {
            System.out.println("Quel joie de vous voir de retour!");
            do {
                System.out.println("Puisque vous êtes "
                        + "déjà familier entrez votre montant de 100$");
                montant = clavier.nextInt();
            } while (montant != 100);
        }
        do {
            for (compteur1 = 0; compteur1 < taille; compteur1++) {
                tabValidation[compteur1] = true;
            }
// Il servira à valider plus tard en changeant les valeurs de ce tableau
//aaprès avoir rempli le tableau le programme peut débuter avec interaction
            System.out.println("Maintenant " + nom
                    + " faites votre choix entre les différentes mises possibles :");
            do {
                System.out.println(" 1.true ou false \n 2."
                        + " Passe ou Manque \n 3. Douzaine \n 4. Six numéros "
                        + "\n 5. Quatres numéros \n 6. Trois numéros \n "
                        + "7. Deux numéros \n 8. Chiffre seul (de 0 à 24) \n "
                        + "Entrez le chiffre correspondant");
                choix = clavier.nextInt();
            } while (choix < 0 || choix > 8);
            // validation du choix entrée

            mise = 0;
            switch (choix) {

                case 1:
                    System.out.println("Bienvenue dans le type True False!");
                    do {
// boucle de validation
                        System.out.println("Entrez votre mise mainteant"
                                + " avec la possibilité de la doubler!");
                        mise = clavier.nextInt();
// on recueille la mise du joueur
                    } while (mise < 0 || mise > montant);

                    System.out.println("Maintenant veuillez entrer votre "
                            + "choix de true ou false");
                    System.out.println("Il est important d'inscrire"
                            + " true ou false sinon il y aura une erreur");
                    trueFalse = clavier.nextBoolean();
// on saisi la donnée de l'utilisateur 
// il est impossible de valider avec nos connaissances actuelles
                    nombreAleatoire = r.nextInt(24) + 1;
// On génère le chiffre aléatoire en excluant le zéro
                    System.out.println("La valeur de nombreAleatoire : "
                            + nombreAleatoire);
                    if (trueFalse == tabBoolean[nombreAleatoire]) {
// dans le cas ou il gagne
                        mise = mise * 2;
                        montant = mise + montant;
// son montant après la mise
                        System.out.println("Félicitation! Votre mise a doublé");

                    } else {
// dans le cas ou il perd
                        System.out.println("Oh non! Vous "
                                + "avez perdu!Ce n'est pas grave!");
                        montant = montant - mise;
// son montant après la mise

                    }
                    break;
                case 2:
                    System.out.println("Bienvenue "
                            + "dans le type Passe ou Manque!");
                    do {
// Boucle validation
                        System.out.println("Entrez votre mise mainteant "
                                + "avec la possibilité de la doubler!");
                        mise = clavier.nextInt();
// on recueille la mise du joueur
                    } while (mise < 0 || mise > montant);

                    do {
// On valide le choix qu'il entre au clavier
                        System.out.println("Entrez maintenant si vous voulez "
                                + "\n 1. passe \n 2. manque \n Entrez 1 ou 2");
                        choix = clavier.nextInt();
                    } while (choix < 1 || choix > 2);
                    nombreAleatoire = r.nextInt(24) + 1;
// On génère le chiffre aléatoire en excluant zéro
                    System.out.println("La valeur de nombreAleatoire : "
                            + nombreAleatoire);
                    if (choix == 1 && bornePasse <= nombreAleatoire) {
// pas besoin d'inclure la borne supérieur car le random a comme maximum le 24
                        mise = mise * 2;
                        System.out.println("WOW! Vous avez gagné!");
                        montant = montant + mise;
                    } else if (choix == 2 && nombreAleatoire < borneManque) {
// pas besoin d'inclure la borne inférieur car le random a comme minimum 1
                        mise = mise * 2;
                        System.out.println("WOW! Vous avez gagné!");
                        montant = montant + mise;
                    } else {
// les cas ou il ne gagne pas
                        montant = montant - mise;
                        System.out.println("Vous avez perdu ! ");
                        System.out.println("Ce n'est pas grave!");
                    }
                    break;
                case 3:
                    System.out.println("Bienvenue dans le type Douzaine!");
                    do {
//boucle validation
                        System.out.println("Entrez votre mise mainteant"
                                + " avec la possibilité de la tripler!");
                        mise = clavier.nextInt();
// on recueille la mise du joueur
                    } while (mise < 0 || mise > montant);

                    do {
//boucle validation
                        System.out.println("Entrez maintenant si vous voulez "
                                + "\n 1. 1-12 \n 2. 13-24 \n Entrez 1 ou 2");
                        choix = clavier.nextInt();
                    } while (choix < 1 || choix > 2);
                    nombreAleatoire = r.nextInt(24) + 1;
// On génère le chiffre aléatoire en excluant zéro
                    System.out.println("La valeur de nombreAleatoire : "
                            + nombreAleatoire);
                    if (choix == 2 && 13 <= nombreAleatoire) {
// pas besoin d'inclure la borne supérieur car le random a comme maximum le 24
                        mise = mise * 3;
                        System.out.println("WOW! Vous avez gagné!");
                        montant = montant + mise;
                    } else if (choix == 1 && nombreAleatoire <= 12) {
// pas besoin d'inclure la borne inférieur car le random a comme minimum 1
                        mise = mise * 3;
                        System.out.println("WOW! Vous avez gagné!");
                        montant = montant + mise;
                    } else {
// les cas ou il ne gagne pas
                        montant = montant - mise;
                        System.out.println("Vous avez perdu ! ");
                        System.out.println("Ce n'est pas grave!");
                    }
                    break;
                case 4:
                    System.out.println("Bienvenue dans le type Six Numéros");
                    do {
//boucle validation
                        System.out.println("Entrez votre mise mainteant "
                                + "avec la possibilité de "
                                + "gagner 6 fois votre mise!");
                        mise = clavier.nextInt();
// on recueille la mise du joueur
                    } while (mise < 0 || mise > montant);

                    do {
                        System.out.println("Vous avez l'option de  \n 1. chosir "
                                //boucle validation
                                + "vos valeurs aléatoirement "
                                + "\n 2.Les choisir vous même "
                                + "\n Entrez 1 ou 2");
                        choix = clavier.nextInt();
                    } while (choix < 1 || choix > 2);
                    switch (choix) {
                        case 1:
// on offre le choix à l'utilisateur pour choisir ses chiffres ou aléatoire
                            for (compteur1 = 0; compteur1 < tabsixNumero.length;
                                    compteur1++) {
// on  remplit aléatoirement
                                do {
// Boucle de validation
                                    tabsixNumero[compteur1] = r.nextInt(25);
                                } while ((tabValidation[tabsixNumero[compteur1]]
                                        == false));
                                // Pas besoin de vérifier entre 0 et 24 la limitation sur le random le fait déjà
                                tabValidation[tabsixNumero[compteur1]]
                                        = false;
                            }

                            break;
                        case 2:
                            for (compteur1 = 0; compteur1 < tabsixNumero.length;
                                    compteur1++) {
                                do {
// Boucle de validation
                                    System.out.println("Entrez vos six valeurs différentes "
                                            + "comprises entre 0 et 24");
                                    tabsixNumero[compteur1] = clavier.nextInt();
                                } while ((tabsixNumero[compteur1] < 0)
                                        || (tabsixNumero[compteur1] > 24)
                                        || (tabValidation[tabsixNumero[compteur1]]
                                        == false));

                                tabValidation[tabsixNumero[compteur1]]
                                        = false;

                            }
                    }
                    for (compteur1 = 0; compteur1 < tabsixNumero.length;
                            compteur1++) {
//Pour trier le tableau et le placer par ordre croissant
// par conséquent si il y a deux mêmes valeurs elles seront une a la suite de l'autre
                        for (compteur2 = compteur1 + 1; compteur2
                                < tabsixNumero.length; compteur2++) {
                            if (tabsixNumero[compteur1] > tabsixNumero[compteur2]) {
                                temp = tabsixNumero[compteur1];
                                tabsixNumero[compteur1] = tabsixNumero[compteur2];
                                tabsixNumero[compteur2] = temp;
                            }
                        }
                    }

                    System.out.println("Voici donc vos valeurs ordonnées");
                    for (compteur1 = 0; compteur1 < tabsixNumero.length;
                            compteur1++) {
// on affiche le tableau
                        System.out.print(tabsixNumero[compteur1] + "  ");
                    }

                    nombreAleatoire = r.nextInt(25);
//Nombre aléatoire incluant zéro
                    System.out.println("Voici la valeur de nombreAleatoire : "
                            + nombreAleatoire);

                    for (compteur1 = 0; compteur1 < tabsixNumero.length;
                            compteur1++) {
                        if (tabsixNumero[compteur1] == nombreAleatoire) {
                            egalite = true;
// on peut savoir si une valeur correspond en traversant tout le tableau
                        }
                    }
                    if (egalite) {
                        System.out.println("Félicitation!Vous avez gagner!");
                        montant = montant + mise * 6;
                    } else {
                        System.out.println("Vous avez perdu! "
                                + "Ce n'est pas grave!");
                        montant = montant - mise;
                    }

                    break;

                case 5:
                    System.out.println("Bienvenue dans le "
                            + "type Quatre Numéros");
                    do {
//boucle validation
                        System.out.println("Entrez votre mise mainteant "
                                + "avec la possibilité de "
                                + "gagner 9 fois votre mise!");
                        mise = clavier.nextInt();
// on recueille la mise du joueur
                    } while (mise < 0 || mise > montant);
                    do {
                        System.out.println("Vous avez l'option de  \n 1. chosir "
                                // boucle validation                      
                                + "vos valeurs aléatoirement "
                                + "\n 2.Les choisir vous même "
                                + "\n Entrez 1 ou 2");
                        choix = clavier.nextInt();
                    } while (choix < 1 || choix > 2);

                    switch (choix) {
                        case 1:

                            for (compteur1 = 0; compteur1 < tabQuatreNumero.length;
                                    compteur1++) {
//On remplit le tableau aléatoirement
                                do {
// boucle de validation pour s'assurer qu'il ne réutilise pas le même chiffre
                                    tabQuatreNumero[compteur1] = r.nextInt(25);
                                } while ((tabValidation[tabQuatreNumero[compteur1]]
                                        == false));
                                // Pas besoin de vérifier entre 0 et 24 la limitation sur le random le fait déjà
                                tabValidation[tabQuatreNumero[compteur1]]
                                        = false;
                            }
                            break;
                        case 2:
                            for (compteur1 = 0; compteur1 < tabQuatreNumero.length;
                                    compteur1++) {
//On remplit le tableau avec les valeurs de l'utilisateur
                                do {
// Boucle de validation
                                    System.out.println("Veuillez entrer"
                                            + " vos quatres chiffres différents");
                                    tabQuatreNumero[compteur1] = clavier.nextInt();
                                } while ((tabQuatreNumero[compteur1] < 0)
                                        || (tabQuatreNumero[compteur1] > 24)
                                        || (tabValidation[tabQuatreNumero[compteur1]]
                                        == false));
                                tabValidation[tabQuatreNumero[compteur1]]
                                        = false;
                            }
                    }

                    for (compteur1 = 0; compteur1 < tabQuatreNumero.length;
                            compteur1++) {
//Pour trier le tableau et le placer par ordre croissant
// par conséquent si il y a deux mêmes valeurs elles seront une a la suite de l'autre
                        for (compteur2 = compteur1 + 1; compteur2
                                < tabQuatreNumero.length; compteur2++) {
                            if (tabQuatreNumero[compteur1] > tabQuatreNumero[compteur2]) {
                                temp = tabQuatreNumero[compteur1];
                                tabQuatreNumero[compteur1] = tabQuatreNumero[compteur2];
                                tabQuatreNumero[compteur2] = temp;
                            }
                        }
                    }

                    System.out.println("Voici donc vos valeurs ordonnées");
                    for (compteur1 = 0; compteur1 < tabQuatreNumero.length;
                            compteur1++) {
// on affiche le tableau
                        System.out.print(tabQuatreNumero[compteur1] + "  ");
                    }

                    nombreAleatoire = r.nextInt(25);
//Nombre aléatoire incluant zéro
                    System.out.println("Voici la valeur de nombreAleatoire : "
                            + nombreAleatoire);

                    for (compteur1 = 0; compteur1 < tabQuatreNumero.length;
                            compteur1++) {
                        if (tabQuatreNumero[compteur1] == nombreAleatoire) {
                            egalite = true;
// on peut savoir si une valeur correspond en traversant tout le tableau
                        }
                    }
                    if (egalite) {
                        System.out.println("Félicitation!Vous avez gagner!");
                        montant = montant + mise * 9;
                    } else {
                        System.out.println("Vous avez perdu! "
                                + "Ce n'est pas grave!");
                        montant = montant - mise;
                    }

                    break;
                case 6:
                    System.out.println("Bienvenue dans le "
                            + "type trois Numéros");
                    do {
//boucle validation
                        System.out.println("Entrez votre mise mainteant "
                                + "avec la possibilité de "
                                + "gagner 12 fois votre mise!");
                        mise = clavier.nextInt();
// on recueille la mise du joueur
                    } while (mise < 0 || mise > montant);
                    do {
                        System.out.println("Vous avez l'option de  \n 1. chosir "
                                // boucle validation                      
                                + "vos valeurs aléatoirement "
                                + "\n 2.Les choisir vous même "
                                + "\n Entrez 1 ou 2");
                        choix = clavier.nextInt();
                    } while (choix < 1 || choix > 2);
                    switch (choix) {
                        case 1:

                            for (compteur1 = 0; compteur1 < tabTroisNumero.length;
                                    compteur1++) {
//On remplit le tableau aléatoirement
                                do {
// boucle de validation pour s'assurer qu'il ne réutilise pas le même chiffre
                                    tabTroisNumero[compteur1] = r.nextInt(25);
                                } while ((tabValidation[tabTroisNumero[compteur1]]
                                        == false));
                                // Pas besoin de vérifier entre 0 et 24 la limitation sur le random le fait déjà
                                tabValidation[tabTroisNumero[compteur1]]
                                        = false;
                            }
                            break;
                        case 2:
                            for (compteur1 = 0; compteur1 < tabTroisNumero.length;
                                    compteur1++) {
//On remplit le tableau avec les valeurs de l'utilisateur
                                do {
// Boucle de validation
                                    System.out.println("Veuillez entrer"
                                            + " vos trois chiffres différents");
                                    tabTroisNumero[compteur1] = clavier.nextInt();
                                } while ((tabTroisNumero[compteur1] < 0)
                                        || (tabTroisNumero[compteur1] > 24)
                                        || (tabValidation[tabTroisNumero[compteur1]]
                                        == false));
                                tabValidation[tabTroisNumero[compteur1]]
                                        = false;
                            }
                    }
                    for (compteur1 = 0; compteur1 < tabTroisNumero.length;
                            compteur1++) {
//Pour trier le tableau et le placer par ordre croissant
// par conséquent si il y a deux mêmes valeurs elles seront une a la suite de l'autre
                        for (compteur2 = compteur1 + 1; compteur2
                                < tabTroisNumero.length; compteur2++) {
                            if (tabTroisNumero[compteur1] > tabTroisNumero[compteur2]) {
                                temp = tabTroisNumero[compteur1];
                                tabTroisNumero[compteur1] = tabTroisNumero[compteur2];
                                tabTroisNumero[compteur2] = temp;
                            }
                        }
                    }

                    System.out.println("Voici donc vos valeurs ordonnées");
                    for (compteur1 = 0; compteur1 < tabTroisNumero.length;
                            compteur1++) {
// on affiche le tableau
                        System.out.print(tabTroisNumero[compteur1] + "  ");
                    }

                    nombreAleatoire = r.nextInt(25);
//Nombre aléatoire incluant zéro
                    System.out.println("Voici la valeur de nombreAleatoire : "
                            + nombreAleatoire);

                    for (compteur1 = 0; compteur1 < tabTroisNumero.length;
                            compteur1++) {
                        if (tabTroisNumero[compteur1] == nombreAleatoire) {
                            egalite = true;
// on peut savoir si une valeur correspond en traversant tout le tableau
                        }
                    }
                    if (egalite) {
                        System.out.println("Félicitation!Vous avez gagner!");
                        montant = montant + mise * 12;
                    } else {
                        System.out.println("Vous avez perdu! "
                                + "Ce n'est pas grave!");
                        montant = montant - mise;
                    }

                    break;
                case 7:
                    System.out.println("Bienvenue dans le "
                            + "type Deux Numéros");
                    do {
//boucle validation
                        System.out.println("Entrez votre mise mainteant "
                                + "avec la possibilité de "
                                + "gagner 18 fois votre mise!");
                        mise = clavier.nextInt();
// on recueille la mise du joueur
                    } while (mise < 0 || mise > montant);
                    do {
                        System.out.println("Vous avez l'option de  \n 1. chosir "
                                // boucle validation                      
                                + "vos valeurs aléatoirement "
                                + "\n 2.Les choisir vous même "
                                + "\n Entrez 1 ou 2");
                        choix = clavier.nextInt();
                    } while (choix < 1 || choix > 2);
                    switch (choix) {
                        case 1:

                            for (compteur1 = 0; compteur1 < tabDeuxNumero.length;
                                    compteur1++) {
//On remplit le tableau aléatoirement
                                do {
// boucle de validation pour s'assurer qu'il ne réutilise pas le même chiffre
                                    tabDeuxNumero[compteur1] = r.nextInt(25);
                                } while ((tabValidation[tabDeuxNumero[compteur1]]
                                        == false));
                                // Pas besoin de vérifier entre 0 et 24 la limitation sur le random le fait déjà
                                tabValidation[tabDeuxNumero[compteur1]]
                                        = false;
                            }
                            break;
                        case 2:
                            for (compteur1 = 0; compteur1 < tabDeuxNumero.length;
                                    compteur1++) {
//On remplit le tableau avec les valeurs de l'utilisateur
                                do {
// Boucle de validation
                                    System.out.println("Veuillez entrer"
                                            + " vos deux chiffres différents");
                                    tabDeuxNumero[compteur1] = clavier.nextInt();
                                } while ((tabDeuxNumero[compteur1] < 0)
                                        || (tabDeuxNumero[compteur1] > 24)
                                        || (tabValidation[tabDeuxNumero[compteur1]]
                                        == false));
                                tabValidation[tabDeuxNumero[compteur1]]
                                        = false;
                            }
                    }
                    for (compteur1 = 0; compteur1 < tabDeuxNumero.length;
                            compteur1++) {
//Pour trier le tableau et le placer par ordre croissant
// par conséquent si il y a deux mêmes valeurs elles seront une a la suite de l'autre
                        for (compteur2 = compteur1 + 1; compteur2
                                < tabDeuxNumero.length; compteur2++) {
                            if (tabDeuxNumero[compteur1] > tabDeuxNumero[compteur2]) {
                                temp = tabDeuxNumero[compteur1];
                                tabDeuxNumero[compteur1] = tabDeuxNumero[compteur2];
                                tabDeuxNumero[compteur2] = temp;
                            }
                        }
                    }

                    System.out.println("Voici donc vos valeurs ordonnées");
                    for (compteur1 = 0; compteur1 < tabDeuxNumero.length;
                            compteur1++) {
// on affiche le tableau
                        System.out.print(tabDeuxNumero[compteur1] + "  ");
                    }

                    nombreAleatoire = r.nextInt(25);
//Nombre aléatoire incluant zéro
                    System.out.println("Voici la valeur de nombreAleatoire : "
                            + nombreAleatoire);

                    for (compteur1 = 0; compteur1 < tabDeuxNumero.length;
                            compteur1++) {
                        if (tabDeuxNumero[compteur1] == nombreAleatoire) {
                            egalite = true;
// on peut savoir si une valeur correspond en traversant tout le tableau
                        }
                    }
                    if (egalite) {
                        System.out.println("Félicitation!Vous avez gagner!");
                        montant = montant + mise * 18;
                    } else {
                        System.out.println("Vous avez perdu! "
                                + "Ce n'est pas grave!");
                        montant = montant - mise;
                    }

                    break;
                case 8:
                    System.out.println("Bienvenue dans le chiffre seul !");
                     {
//boucle validation
                        System.out.println("Entrez votre mise mainteant "
                                + "avec la possibilité de "
                                + "gagner 24 fois votre mise!");
                        mise = clavier.nextInt();
// on recueille la mise du joueur
                    }
                    while (mise < 0 || mise > montant);
                    do {
                        System.out.println("Vous avez l'option de  \n 1. chosir "
                                // boucle validation                      
                                + "vos valeurs aléatoirement "
                                + "\n 2.Les choisir vous même "
                                + "\n Entrez 1 ou 2");
                        choix = clavier.nextInt();
                    } while (choix < 1 || choix > 2);

                    switch (choix) {
                        case 1:
//On remplit le tableau aléatoirement
                            chiffreSeul = r.nextInt(25);
                            // Pas besoin de vérifier entre 0 et 24 la limitation sur le random le fait déjà 
                            break;
                        case 2:
//On remplit le tableau avec les valeurs de l'utilisateur
                            do {
// Boucle de validation
                                System.out.println("Veuillez entrer"
                                        + " votre chiffre ");
                                chiffreSeul = clavier.nextInt();
                            } while ((chiffreSeul < 0)
                                    || (chiffreSeul > 24));
                    }
                    System.out.println("Voici votre chiffre seul : " + chiffreSeul);
                    nombreAleatoire = r.nextInt(25);
//Nombre aléatoire incluant zéro
                    System.out.println("Voici la valeur de nombreAleatoire : "
                            + nombreAleatoire);

                    if (chiffreSeul == nombreAleatoire) {
                        egalite = true;
// on peut savoir si une valeur correspond 
                    }

                    if (egalite) {
                        System.out.println("Félicitation!Vous avez gagner!");
                        montant = montant + mise * 24;
                    } else {
                        System.out.println("Vous avez perdu! "
                                + "Ce n'est pas grave!");
                        montant = montant - mise;
                    }
            }
            gain = montant - montIni;
            if (gain < 0) {
                gain = 0;
            }

            System.out.println("Voulez-vous recommencer? Entrez 1 ou 2 "
                    + "\n 1.oui \n 2.Non \n "
                    + "Vous avez un montant de : " + montant + ""
                    + "\n Vous avez un gain de : " + gain);

            choix = clavier.nextInt();

        } while (montant != 0 && choix == 1);
        if (montant <= 0) {
            System.out.println("Désolée vous n'avez plus d'argent!");
        }
        System.out.println("Merci d'avoir fait confiance à la machine du passé!");

    }

}

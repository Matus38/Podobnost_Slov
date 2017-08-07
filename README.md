# Podobnost_Slov

Urobte program ktorý načíta súbor ľubovoľný textový súbor so slovami rôznych dĺžok)
a vstupné slovo o veľkosti aspoň 3 znaky ( ďalej VS ) ako vstup z konzoly. Program 
prehľadá súbor a nájde slová ktoré sa tomuto slovu podobajú najviac, nehľadiac na 
veľké a malé písmená, a vypíše prvých 10 najpodobnejších aj s ich koeficientom 
podobnosti. Pri programovaní použite iba vstavané knižnice jazyka Java, dbajte 
na efektivitu riešenia, váš výsledok budeme overovať na veľkom súbore.
Príklad: VS="rog"
Výstup pri súbore ktorý by obsahoval všetky slová uvedené nižšie:
1. RoG - koeficient podobnosti 3 // prakticky sa rovnajú 
2. Frog - koeficient podobnosti 3 // je nižšie v rebríčku lebo slovo je dlhšie a teda menej podobné 
3. Programátor - koeficient podobnosti 3
4. Dog - koeficient podobnosti 2 // obsahuje v sebe "og"
4. Jaro - koeficien podobnosti 2 // obsahuje v sebe "ro", je ale nižšie ako Dog lebo má viac písmen
5.Rado - koeficient podobnosti 1 obsahuje sice R aj O, ale iba osamotene, a teda najvačia podobná časť má dĺžku 1 znak 
6. ...

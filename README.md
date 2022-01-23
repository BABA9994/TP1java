# TP1java
TP1java ENSEA 3D

Avec ce TP, j'ai appris les bases de java et pu mettre en application ce que j'ai appris sur les objets, les classes, les méthodes et les constructeurs.
J'ai également pu apréhender les bases de javafx et réaliser une partie de ce TP.

Je n'ai pas reussi à arriver à l'étape des requetes API. Cependant je vois tout a fait ce que cela represente, j'aurai aimé cependant de voir comment cela fonctionne en java.

Sur ce TP, je ne comprend toujours pas comment faire pour avoir une terre qui fait un révolution complete en 15 secondes, la méthode handle est executé toutes les 16ms, donc il faut que la terre tourne de 0.364 degres toutes les 16 ms pour faire 1 tour en 15 secondes.
Cependant cela ne marche pas du tout, les valeurs de time en ns s'incrementent tres vite, et pas toujours de la meme valeur... 
Il semble que la méthode handle s'execute bien plus de fois que 62.5 fois par secondes (= 1/0.016)
En recherchant un peu sur internet, il semble que la méthode handle s'éxecute à chaque rafraichissement d'image par javafx, cela dépend donc de l'écran ?

Après des recherches, effectivement ayant un écran 165Hz, j'ai refait le calcul, et saisi la nouvelle valeur de 0.145, cela marche beaucoup mieux.

Avec ce TP, j'ai donc appris pour les bases de java, et des moteur 3D comme JavaFx, ayant vu de nombreux tutoriels sur internet, ils faisaient souvent le rapprochement avec minecraft, et je comprend mieux comment certaines fonctionnalités de ce jeu fonctionnent. Je doute cependant qu'ils aient utilisé Javafx... ????

Pour mon travail, je vais devoir réaliser une intergration de différents systèmes qui communiquent avec une API, ou en SNMP.
Je vais donc choisir un language afin de developpper ce connecteur, et donc regarder du coté des requetes HTTP en Java peut etre ??

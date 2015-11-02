<?php
session_start();


$string = file_get_contents("outputfile.txt");
var_dump($string);

?>
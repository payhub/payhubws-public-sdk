<?php
session_start();
file_put_contents("outputfile.txt", file_get_contents("php://input"));
http_response_code(200);
?>
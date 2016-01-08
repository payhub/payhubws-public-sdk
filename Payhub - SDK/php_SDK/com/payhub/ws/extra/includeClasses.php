<?php
/**
 * Created by PhpStorm.
 * User: agustin
 * Date: 28/07/2015
 * Time: 10:21
 */
$directories = array(
    dirname(__DIR__).DIRECTORY_SEPARATOR.'util',
    dirname(__DIR__).DIRECTORY_SEPARATOR.'model',
    dirname(__DIR__).DIRECTORY_SEPARATOR.'api',
    dirname(__DIR__).DIRECTORY_SEPARATOR.'vt'
);
$files;
foreach ($directories as $directory) {
    $aux=directoryToArray($directory);
    $files[]=$aux;
}
foreach($files as $generalPath){
    foreach($generalPath as $pathToFile)
    {
        include_once "$pathToFile";
    }
}

function directoryToArray($directory, $recursive = true, $listDirs = false, $listFiles = true, $exclude = '') {
    $arrayItems = array();
    $skipByExclude = false;
    $handle = opendir($directory);
    if ($handle) {
        while (false !== ($file = readdir($handle))) {
            preg_match("/(^(([\.]){1,2})$|(\.(svn|git|md|java|bak))|(Thumbs\.db|\.DS_STORE))$/iu", $file, $skip);
            if($exclude){
                preg_match($exclude, $file, $skipByExclude);
            }
            if (!$skip && !$skipByExclude) {
                if (is_dir($directory. DIRECTORY_SEPARATOR . $file)) {
                    if($recursive) {
                        $arrayItems = array_merge($arrayItems, directoryToArray($directory. DIRECTORY_SEPARATOR . $file, $recursive, $listDirs, $listFiles, $exclude));
                    }
                    if($listDirs){
                        $file = $directory . DIRECTORY_SEPARATOR . $file;
                        $arrayItems[] = $file;
                    }
                } else {
                    if($listFiles){
                        $file = $directory . DIRECTORY_SEPARATOR . $file;
                        $arrayItems[] = $file;
                    }
                }
            }
        }
        closedir($handle);
    }
    return $arrayItems;
}
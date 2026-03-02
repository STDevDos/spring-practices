$paths = Get-ChildItem -Recurse -Filter pom.xml
foreach ($file in $paths) {
    Write-Host "Processing $($file.FullName)"
    $content = Get-Content $file.FullName -Raw
    $newContent = $content -replace '<groupId>mysql</groupId>\s*<artifactId>mysql-connector-java</artifactId>', '<groupId>com.mysql</groupId>`n            <artifactId>mysql-connector-j</artifactId>'
    $newContent = $newContent -replace '<version>\${mysql-connector-java\.version}</version>', ''
    
    if ($content -ne $newContent) {
        Write-Host "Updating $($file.FullName)"
        Set-Content $file.FullName $newContent
    }
}

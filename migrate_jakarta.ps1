$paths = Get-ChildItem -Recurse -Filter *.java
foreach ($file in $paths) {
    Write-Host "Processing $($file.FullName)"
    $content = Get-Content $file.FullName -Raw
    $newContent = $content -replace 'javax\.persistence\.', 'jakarta.persistence.'
    $newContent = $newContent -replace 'javax\.validation\.', 'jakarta.validation.'
    $newContent = $newContent -replace 'javax\.servlet\.', 'jakarta.servlet.'
    $newContent = $newContent -replace 'javax\.annotation\.', 'jakarta.annotation.'
    $newContent = $newContent -replace 'javax\.transaction\.', 'jakarta.transaction.'
    $newContent = $newContent -replace 'javax\.xml\.bind\.', 'jakarta.xml.bind.'
    $newContent = $newContent -replace 'javax\.mail\.', 'jakarta.mail.'
    $newContent = $newContent -replace 'javax\.inject\.', 'jakarta.inject.'
    
    if ($content -ne $newContent) {
        Write-Host "Updating $($file.FullName)"
        Set-Content $file.FullName $newContent
    }
}

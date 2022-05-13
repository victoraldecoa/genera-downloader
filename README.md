# genera-downloader

Baixe todos os seus relatórios da Genera de uma vez em HTML, sem precisar ficar abrindo página por
página.

## Instruções

Abra sua conta da Genera, aperte F12, aperte Network (no Firefox, ou similar em outros Browsers),
atualize a página, clique em qualquer request para exames.genera.com.br e dentro de Request Headers
ache "Cookie". Copie seu conteúdo, abra o namespace `genera_downloader.clj` e cole no var `cookie`.
Rode um REPL nesse namespace e chame a função `(save-reports-as-html)`. Todos os htmls serão
baixados na pasta `out`.

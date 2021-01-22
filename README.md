# MARKUP
Aplicativo Android feito em linguagem Kotlin. Criado como requisito para a avaliação técnica da Compasso UOL.

## INTRODUÇÃO

Aplicativo de anúncio de eventos, com tela de detalhes, localização, check-in e favoritos.

## INTEGRIDADE LOCAL

As funcionalidades:

* Favoritos;
* Dados de check-in.

Possuem apenas integridade local, ou seja, se os dados do app forem limpos, assim como o app for desinstalado, esses dados serão perdidos.
Resaltando que, o intuito destas funcionalidades é de demonstrar como este app poderia ser desenvolvido e quais
funcionalidades foram percebidas como facilitadoras de UX.

## FAVORITOS

Os eventos 'curtidos' na tela inicial aparecerão na aba <b>Favoritos</b> do menu inferior.

## CHECK-IN

Os dados que são solicitados quando o app for aberto pela primeira vez serão salvos e reutilizados por esta funcionalidade.
Na tela de detalhes do evento, pressione o botão check-in.

## COMPARTILHAR

Na tela de detalhes do evento, na barra superior, pressione o ícone de compartilhar para enviar um texto com dados do evento.

# DEPENDÊNCIAS

* [Material components]()
* [Glide]()
* [Retrofit]()
* [Koin]()
* [Navigation]()
* [ViewModel]()
* [LiveData]()
* [Databinding]()
* [Room]()

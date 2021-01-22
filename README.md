# MARKUP
Aplicativo Android feito em linguagem Kotlin. Criado como requisito para a avaliação técnica da Compasso UOL.

## INTRODUÇÃO

Aplicativo de anúncio de eventos, com tela de detalhes, localização, check-in e favoritos.

Se desejar, você pode baixar o aplicativo [aqui](/apk/app-markup.apk)

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

* [Material components](https://material.io/resources/get-started#design)
* [Glide](https://github.com/bumptech/glide)
* [Retrofit](https://square.github.io/retrofit/)
* [Koin](https://insert-koin.io/)
* [Navigation](https://developer.android.com/guide/navigation/navigation-getting-started)
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata?hl=pt-br)
* [Databinding](https://developer.android.com/topic/libraries/data-binding?hl=pt-br)
* [Room](https://developer.android.com/training/data-storage/room)

# ARQUITETURA

Para este projeto foi escolhido o padrão de projeto MVVC.

Diversos são os fatores que levam a escolha do mesmo, são:

* Aconselhado pela equipe de desenvolvedores Android;
* Facilita as interações de teste, desacoplando as regras de negócio;
* Junto do databinding, reduz o código de instrução das views evitando, em vários casos,
a necessidade de colocar diretamente no código situações que lidam com views (esconder e mostrar uma view, por exemplo);
* Encapsula regras de negócio, minimizando código e evitando boilerplate;

# Banco de dados do projeto VOOAZ 


Este projeto visa desenvolver um **sistema de viagens** para pessoas com deficiênficias visuais ou auditiva. Nosso banco de dados,tem o objetivo de recolher informações de usuários e serviços prestados, criando um ambiente colaborativo e acolhedor.

##  Objetivo
- Gestão de **Recursos** e **Serviços**.
- Cadastro  de **Usuários**, **Guias** e **Destinos**.
- Controle de **Reservas**.
- Conexão entre usuários e serviços.
- Descrição de locais acessíveis.

---

##  Usuários

Os dados extraídos oferecem insights valiosos sobre o perfil e as preferências dos clientes. Detalhando como transformar essas informações em estratégias eficazes para aprimorar serviços e personalizar experiências. Garantir que cada cliente se sinta valorizado e tenha uma experiência única, combinando tecnologia, personalização e empatia.

*Estrutura do banco*

Identidade do Cliente: Nome e contato.
Características Pessoais: Tipo de deficiência e data de nascimento (para criar experiências inclusivas e adequadas à faixa etária).
Reservas: Histórico de interações e preferências de viagem.

*Personalização de experiência*
Os dados permitem criar ofertas e comunicações sob medida.

* Recomendações Baseadas no Perfil: Sugestões de destinos acessíveis ou adaptados.
*Planos Personalizados: Oferecer planos alinhados às necessidades e preferências do cliente, como viagens culturais ou reservas adaptadas.
*Reconhecimento de Fidelidade: Oferecer benefícios exclusivos para clientes recorrentes.

*Uso do Histórico de Reservas*

*Oferecer descontos personalizados ou pacotes baseados no histórico de viagens.
*Enviar notificações sobre eventos e locais relevantes previamente visitados.
*Incentivar feedback do cliente para adaptar e melhorar continuamente os serviços oferecidos.
```js
{
  "_id": {
    "$oid": "674091ed0f69f25217eba241"
  },
  "nome": "Gisele Massafera de Sousa",
  "email": "giselemassafera@gmail.com",
  "senha": "massafera@3012",
  "tipoDeficiencia": "Auditiva",
  "dataNascimento": {
    "$date": "1996-04-08T00:00:00.000Z"
  },
  
  // Esses dados são fictícios, e meramente demonstrativos.
 
}
```

## Guias acessíveis
Os guias locais são a peça-chave do nosso banco de dados. Cada guia é cuidadosamente selecionado para proporcionar aos usuários experiências autênticas, personalizadas e acessíveis, de acordo com seus destinos e necessidades.

*Estrutura dos Dados*
*Identificação: Nome, idioma e especialidade.
*Localização: País, estado, cidade e bairro, facilitando a conexão com turistas em destinos específicos.
*Idiomas Falados: Permite atender viajantes internacionais de forma eficaz.
*Avaliação: Pontuação média baseada no feedback de usuários, garantindo a qualidade do serviço.
*Especialidade e Tipo de Guia: Informações sobre foco de atuação (autônomo ou vinculado a empresas) e especialização em deficiências.

*Benefícios para o Usuário*
*Autenticidade: Guias locais com profundo conhecimento cultural e regional.
*Confiança: Sistema de avaliações para garantir qualidade.
*Personalização: Guias disponíveis em diferentes idiomas e especializados em necessidades específicas, incluindo acessibilidade.

```js
{
  "_id": {
    "$oid": "6740af0728680fbb345d4a6c"
  },
  "nome": "Felipe Barbosa Queiroz",
  "especialidade": "Guia de Turismo Cultural",
  "pais": "Itália",
  "estado": "Vêneto",
  "cidade": "Veneza",
  "bairro": "San Polo",
  "idiomas": [
    "Português",
    "Espanhol",
    "Italiano"
  ],
  "avaliacao": 4.5,
  "email": "felipebarbosa@gmail.com",
  "contato": "+39041.4862378",
  "tipo": "Vinculado a empresa",
  "especialidadeDeficiencia": "Ambos"
}
// Esses dados são fictícios, e meramente demonstrativos
```

## Destinos
Nosso banco de destinos turísticos é projetado para oferecer experiências únicas e inclusivas aos viajantes. Com foco em acessibilidade e diversidade cultural, cada destino é cuidadosamente descrito para ajudar os usuários a escolherem locais que atendam às necessidades e preferências.

*Estrutura dos Dados*

*Destino: Nome do local que será exibido para o usuário.
*Categoria: Classificação do destino (cultural, natural, histórico, etc.).
*Localização: País, estado e cidade, permitindo segmentação geográfica e fácil busca.
*Descrição: Uma descrição atraente que captura a essência do destino, destacando seus atrativos e experiências únicas.
*Acessibilidade: Os usuários podem filtrar destinos que oferecem recursos adaptados para deficiência visual e auditiva, garantindo experiências inclusivas.

Deficiência Visual: Indicação se o local possui infraestrutura e recursos adequados, como placas em braille ou guias táteis.
Deficiência Auditiva: Informações sobre adaptações como intérpretes de Libras ou guias visuais.

```js {
  "_id": {
    "$oid": "645aedc0f5564331f0e7cc01"
  },
  "nome": "Parque Ibirapuera",
  "categoria": "Parque",
  "localizacao": "Av. Pedro Álvares Cabral - Vila Mariana",
  "cidade": "São Paulo",
  "estado": "SP",
  "pais": "Brasil",
  "descricao": "Um dos maiores parques urbanos de São Paulo, ideal para caminhadas, piqueniques e atividades ao ar livre.",
  "acessibilidade": {
    "deficienciaVisual": true,
    "deficienciaAuditiva": true
  }
}
```

## Avaliações
Este banco de dados armazena as avaliações feitas por usuários em relação aos guias e destinos visitados. Ele é uma fonte crucial para monitorar a qualidade dos serviços oferecidos, identificar oportunidades de melhoria e destacar os pontos fortes de guias e destinos.

* Estrutura dos Dados*
*ID do Usuário: Conecta a avaliação a um usuário específico, permitindo uma análise personalizada.
*ID do Guia: Identifica o guia associado à experiência avaliada.
*ID do Destino: Local vinculado à avaliação.
 
*Informações da Avaliação*

*Tipo de Deficiência: Detalha a condição do usuário, ajudando a avaliar a adequação do serviço para diferentes necessidades.
*Nota de Avaliação: Pontuação atribuída pelo usuário (geralmente em uma escala de 1 a 5).
*Comentário: Feedback textual, que oferece insights qualitativos sobre a experiência.
*Data: Registro da data em que a avaliação foi feita, útil para monitorar tendências ao longo do tempo.

*Estratégias de Utilização*
*Destaque de Guias e Destinos Bem Avaliados.
*Identificação de Pontos de Melhoria.
*Personalização de Experiência.
```js
{
  "_id": {
    "$oid": "674339ea9ea4009061c7b650"
  },
  "usuario_id": {
    "$oid": "674091ed0f69f25217eba240"
  },
  "nome": " Nicolas Bittencort Alencar",
  "guia_id": {
    "$oid": "6740af0728680fbb345d4a6c"
  },
  "destinos_id": {
    "$oid": "6738b60155757f7cbada6651"
  },
  "tipoDeDeficiencia": "visual",
  "notaDeAvaliação": 5,
  "Comentário": " É raro encontrar guias tão bem preparados para atender pessoas cegas. As descrições detalhadas e a oportunidade de explorar os lugares com o toque e o som foram emocionantes. Me senti totalmente incluído e conectado com cada destino.",
  "data": {
    "$date": "2024-03-03T00:00:00.000Z"
  }
}
// Esses dados são fictícios, meramente demonstrativos.

```

# Reservas
O sistema de reservas é uma peça essencial para conectar usuários a guias e destinos, permitindo que experiências personalizadas sejam organizadas de forma eficiente e inclusiva. Este banco de dados documenta cada reserva, relacionando usuários, guias, destinos e planos.

*Estrutura dos Dados*
*ID da Reserva: Identifica unicamente cada reserva no sistema.
*ID do Usuário: Associa a reserva a um usuário específico.
*ID do Guia: Indica qual guia será responsável por acompanhar o usuário na experiência.
*ID do Destino: Define o local reservado pelo usuário.
*ID do Plano: Refere-se ao plano contratado pelo usuário, indicando benefícios e serviços incluídos.
*Organização e Planejamento*

*Gestão de Agendas: Guias podem acessar reservas futuras e se preparar para oferecer um serviço de qualidade.
*Notificações Automáticas: Alertas enviados aos usuários sobre a data da reserva e lembretes adicionais.

*Personalização*

*Associação ao Plano: Identificar os benefícios disponíveis ao usuário no momento da reserva, como transporte acessível ou guias especializados.
*Histórico de Reservas: Facilitar a recomendação de destinos e serviços baseados em experiências anteriores do usuário.
*Simplicidade e Conveniência: Reservas feitas com poucos cliques, com informações claras e detalhadas.
*Segurança: Garantia de que suas experiências estão organizadas e confirmadas.
```js
{
  "_id": {
    "$oid": "6740bd1e9f7cdb00ef5ef1f4"
  },
  "usuario_id": {
    "$oid": "635aecd0e5564331f0e7bb35"
  },
  "guia_id": {
    "$oid": "6740af0728680fbb345d4a6e"
  },
  "destino_id": {
    "$oid": "67390bad34736bb489f89ab6"
  },
  
  "data_reserva": {
    "$date": "2024-12-20T00:00:00.000Z"
  }
}
// Esses dados são fictícios, meramentes demonstrativos.

```










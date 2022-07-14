
<jsp:include page="WEB-INF/pages/comunes/inicioHTML.jsp"/>

<jsp:include page="WEB-INF/pages/comunes/inicioHead.jsp"/>
<title>P�gina principal</title>
<jsp:include page="WEB-INF/pages/comunes/finHead.jsp"/>

<jsp:include page="WEB-INF/pages/comunes/nav.jsp"/>

<div class="p-5 mb-4 rounded-3">
    <div class="container-fluid py-5 col-8">
        <h1 class="display-5 fw-bold">Bienvenido a la p�gina web!</h1>
        <p class="fs-4">Este es un proyecto CRUD (Create, Read, Update, Delete) con fines educativos para el programa "Codo a Codo", con el objetivo de crear un listado de juegos, otorgarles una peque�a descripci�n, estado de finalizaci�n, link de compra/descarga y etiquetas para encontrarlos</p>
        <a class="btn verde-oscuro text-light btn-lg" href="${pageContext.request.contextPath}/app">Ir a la app</a>
    </div>
</div>
    
<jsp:include page="WEB-INF/pages/comunes/footer.jsp"/>
    
<jsp:include page="WEB-INF/pages/comunes/finHTML.jsp"/>
$(function() {
    $("#filter-by-role input").change(function() {
        var showRoles = [];
        $("#filter-by-role input:checked").each(function() {
            var role = $(this).val();
            showRoles.push(role);
        });
        
        $("table tr:not(:first)").each(function() {
           var row = $(this);
           var role = row.find("td:eq(2) select option:selected").text();
           if($.inArray(role, showRoles) != -1) {
               row.show();
           } else {
               row.hide();
           }
        });
    });
    $("table tr:not(:first) a:contains('Remove')").click(function() {
        var row = $(this).parents("tr").first();
        row.remove();
    });
    $("#save-discard button:contains('Save')").click(function() {
        if(confirm("Save changes?")) {
            alert("Changes confirmed");
        } else {
            alert("Changes discarded");
        }
    });
});
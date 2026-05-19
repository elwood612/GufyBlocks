#target photoshop

var doc = app.activeDocument;

// === CONFIG ===
var framesGroup = doc.layerSets.getByName("FRAMES");
var terracottaGroup = doc.layerSets.getByName("TERRACOTTA");

var outputFolder = Folder.selectDialog("Choose export folder");
if (!outputFolder) {
    alert("No folder selected.");
    throw new Error("Export cancelled.");
}

// Hide all layers in a group
function hideAll(group) {
    for (var i = 0; i < group.layers.length; i++) {
        group.layers[i].visible = false;
    }
}

// Export PNG
function exportPNG(fileName) {
    var file = new File(outputFolder + "/" + fileName + ".png");

    var opts = new PNGSaveOptions();
    doc.saveAs(file, opts, true, Extension.LOWERCASE);
}

// Main loop
hideAll(framesGroup);
hideAll(terracottaGroup);

for (var f = 0; f < framesGroup.layers.length; f++) {

    var frameLayer = framesGroup.layers[f];
    frameLayer.visible = true;

    for (var t = 0; t < terracottaGroup.layers.length; t++) {

        var terraLayer = terracottaGroup.layers[t];
        terraLayer.visible = true;

        var fileName = frameLayer.name + "_" + terraLayer.name;
        exportPNG(fileName);

        terraLayer.visible = false;
    }

    frameLayer.visible = false;
}

alert("Done!");
/*
 * Vertex shader.
 */
#version 400

// Incoming vertex position, Model Space.
in vec3 position;
// Incoming texture coordinates.
in vec2 texCoord;

// Uniform matrix from Model Space to Clip Space.
uniform mat4 modelMatrix;
uniform mat4 projectionMatrix;
uniform vec4 baseColor;

// Outgoing texture coordinates.
out vec2 interpolatedTexCoord;

void main() {

    // Normally gl_Position is in Clip Space and we calculate it by multiplying 
    // it with the modelToClipMatrix.
    gl_Position = projectionMatrix * modelMatrix * vec4(position, 1);

     // We assign the texture coordinate to the outgoing variable.
    interpolatedTexCoord = texCoord;
}
